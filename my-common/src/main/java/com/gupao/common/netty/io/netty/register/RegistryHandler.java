package com.gupao.common.netty.io.netty.register;

import com.gupao.common.netty.io.netty.protocal.InvockerProtocol;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
@Data
@Slf4j
public class RegistryHandler extends ChannelInboundHandlerAdapter {

    private List<String> classNames = new ArrayList<String>();

    private Map<String,Object> registryMap = new ConcurrentHashMap<String,Object>();


    public RegistryHandler(){
        //1.扫描包名下的所有符合条件的Class放入容器中
        scannerClass("com.gupao.common.netty.io.netty.provider");
        //2.给每一个对应的Class一个名字，作为服务名称，保存到容器中
        doRegistry();
    }

    private void doRegistry() {
        if(classNames.isEmpty()) return;

        for (String className:classNames) {
            try {
                Class<?> aClass = Class.forName(className);
                Class<?> i = aClass.getInterfaces()[0];
                String serviceName = i.getName();
                registryMap.put(serviceName,aClass.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 正常拉说，应该是扫描注解
     * @param packageName
     */
    private void scannerClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        for (File files:file.listFiles()) {
            if(files.isDirectory()){
                scannerClass(packageName+"."+ files.getName());
            }else{
                classNames.add(packageName + "." + files.getName().replace(".class",""));
            }

        }


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        //服务方连接成功时会回调该方法
        Object result = new Object();
        InvockerProtocol request = (InvockerProtocol) msg;
        if(registryMap.containsKey(request.getClassName())){
            //找到请求协议中的接口名称，则调用返回
            Object service = registryMap.get(request.getClassName());
            Method method = service.getClass().getMethod(request.getMethodName(), request.getParams());
            result = method.invoke(service, request.getValues());
        }

        //返回给客户端
        ctx.write(result);
        ctx.flush();
        ctx.close();
    }


}
