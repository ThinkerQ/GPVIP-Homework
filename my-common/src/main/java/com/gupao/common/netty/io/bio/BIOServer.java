package com.gupao.common.netty.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞IO服务端
 * @Author: GengGhuQiang
 * @Date: 2020/8/8
 */
@Slf4j
public class BIOServer {
    /**
     * java实现的通信组件都是使用ServerSocket实现的，如Zookeeper  等
     */
    private ServerSocket serverSocket;

    private Integer port;

    public BIOServer(Integer port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.port = port;
    }

    /**
     * 服务端一直处于监听状态
     */
    private void listen(){
        log.info("服务开始监听.....");
        try {
            while (true){
                //此处会阻塞直到监听到IO数据
                Socket accept = serverSocket.accept();
                int port = accept.getPort();
                InputStream inputStream = accept.getInputStream();
                byte [] bytes= new byte[1024];
                int len = inputStream.read(bytes);
                if(len > 0){
                    String content = new String(bytes,0,len);
                    log.info("监听到来自端口:{} 发送的内容：{}",port,content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        BIOServer socket = new BIOServer(8080);
        socket.listen();
    }
}
