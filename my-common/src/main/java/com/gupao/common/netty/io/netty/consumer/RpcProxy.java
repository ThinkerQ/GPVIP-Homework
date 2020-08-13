package com.gupao.common.netty.io.netty.consumer;

import com.gupao.common.netty.io.netty.protocal.InvockerProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
@Slf4j
public class RpcProxy {

    /**
     * 创建接口的代理
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<?> clazz){
        log.info("===客户端使用动态代理给接口创建代理对象=====");
        MyMethodProxy proxy = new MyMethodProxy(clazz);
        T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, proxy);
        return result;
    }

    private static class MyMethodProxy implements InvocationHandler{

        private Class<?> clazz;

        public MyMethodProxy(Class<?> clazz){
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("===invoke 执行回调方法=====");
            if(Object.class.equals(method.getDeclaringClass())){
                log.info("===invoke 当前类不是接口，直接反射调用方法1=====");
                return method.invoke(this,args);
            }else{
                log.info("===invoke 当前类是接口，准备调用远程接口=====");
                return rpcInvocker(proxy,method,args);
            }
        }

        private Object rpcInvocker(Object proxy, Method method, Object[] args) {
            log.info("===rpcInvocker 先构造一个协议内容=====");
            //先构造一个协议内容
            InvockerProtocol protocol = new InvockerProtocol();
            protocol.setClassName(this.clazz.getName());
            protocol.setMethodName(method.getName());
            protocol.setParams(method.getParameterTypes());
            protocol.setValues(args);
            //发起网络请求
            NioEventLoopGroup workerGroup = new NioEventLoopGroup();
            Bootstrap client = new Bootstrap();
            final RpcProxyHandler proxyHandler = new RpcProxyHandler();

            log.info("===rpcInvocker 发起网络请求=====");
            client.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //在netty中，把所有的业务逻辑都归结到一个队列中，包含各种处理逻辑，封装到了Pipline中
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //对自定义协议的内容进行编解码
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                            //自定义编码器
                            pipeline.addLast(new LengthFieldPrepender(4));
                            //实参处理
                            pipeline.addLast("encoder",new ObjectEncoder());
                            pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            //执行自己的业务逻辑
                            pipeline.addLast(proxyHandler);

                        }
                    });

            try {
                log.info("===rpcInvocker 启动远程连接 localhost:8080》》》》》》》");
                ChannelFuture future = client.connect("localhost", 8080).sync();
                //使用channel将协议内容写入且刷新之后，服务端会接收到com.gupao.common.netty.io.netty.register.RegistryHandler.channelRead 进行处理
                future.channel().writeAndFlush(protocol).sync();
                future.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                workerGroup.shutdownGracefully();
            }
            return proxyHandler.getResponse();
        }
    }
}
