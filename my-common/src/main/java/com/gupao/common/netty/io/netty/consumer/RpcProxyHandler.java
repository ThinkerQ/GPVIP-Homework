package com.gupao.common.netty.io.netty.consumer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
@Slf4j
public class RpcProxyHandler extends ChannelInboundHandlerAdapter {

    private Object response;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("RpcProxyHandler===channelRead=回调处理远程接口的响应内容==", msg.toString());
        response = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      log.info("====exceptionCaught====发生异常");
    }

    public Object getResponse(){
        return response;
    }
}
