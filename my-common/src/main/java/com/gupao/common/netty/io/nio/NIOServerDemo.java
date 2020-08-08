package com.gupao.common.netty.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 同步非阻塞IO模型
 * 当文件描述符数据未准备就绪时，用户线程也可以得到反馈，不用阻塞等待。而是通过轮询的方式 不断询问数据状态。
 * NIO操作过于繁琐，于是出现了Netty进行了封装
 * @Author: GengGhuQiang
 * @Date: 2020/8/8
 */
@Slf4j
public class NIOServerDemo {
    //轮询器
    private Selector selector;

    //缓存区
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    private int port;

    public NIOServerDemo(int port) {
        //初始化轮询器
        this.port = port;
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            //设置为非阻塞的
            channel.configureBlocking(false);
            //轮询器准备就绪
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new NIOServerDemo(8080).listen();
    }

    private void listen() {
        log.info("开始监听端口：{}",port);
        //模拟轮询主线程
        try {
            while (true){
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                //同步体现在这里，每次只能处理一个key 虽然没有阻塞，但是需要不断轮询
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    //业务处理,每个key代表一种状态
                    process(key);
                }
                log.info("====轮询结束============");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void process(SelectionKey key) throws IOException {
        if(key.isAcceptable()){
            //数据准备就绪
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = server.accept();
            log.info("====数据已准备就绪===isAcceptable===没有被阻塞");
            socketChannel.configureBlocking(false);
            //当数据准备就绪时，将状态改为可读，方便下次轮询时处理可读状态
            socketChannel.register(selector,SelectionKey.OP_READ);
        }else if (key.isReadable()){
            //数据可读
            SocketChannel channel = (SocketChannel) key.channel();
            int len = channel.read(buffer);
            if(len > 0){
                buffer.flip();
                String s = new String(buffer.array(), 0, len);
                key = channel.register(selector, SelectionKey.OP_WRITE);
                //在key上携带内容，方便写出
                key.attach(s);
                log.info("====读取的内容{}",s);
            }

        }else if(key.isWritable()){
            //数据可写
            SocketChannel channel = (SocketChannel) key.channel();
            String attachment = (String) key.attachment();
            log.info("====可写的内容{}",attachment);
            channel.write(ByteBuffer.wrap(("输出内容"+attachment).getBytes()));
            channel.close();

        }
    }

}
