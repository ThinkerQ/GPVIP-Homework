package com.gupao.common.netty.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * 同步阻塞IO客户端
 * @Author: GengGhuQiang
 * @Date: 2020/8/8
 */
@Slf4j
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream ops = socket.getOutputStream();
        String content = UUID.randomUUID().toString();
        log.info("客户端发送内容:{}",content);
        ops.write(content.getBytes());
        ops.close();
    }
}
