package com.gupao.common.netty.io.netty.consumer;

import com.gupao.common.netty.io.netty.api.IRpcHelloService;
import com.gupao.common.netty.io.netty.api.IRpcService;
import com.gupao.common.netty.io.netty.provider.RpcHelloServieImpl;
import com.gupao.common.netty.io.netty.provider.RpcServiceImpl;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
public class RpcConsumer {

    public static void main(String[] args) {
        //本地调用
        IRpcHelloService helloServie = RpcProxy.create(IRpcHelloService.class);
        System.out.println(helloServie.hello("GSQ==="));

        IRpcService rpcService = RpcProxy.create(IRpcService.class);
        System.out.println("10 + 2 = " + rpcService.add(10,2));
        System.out.println("10 - 2 = " + rpcService.sub(10,2));
        System.out.println("10 * 2 = " + rpcService.mult(10,2));
        System.out.println("10 / 2 = " + rpcService.div(10,2));
    }
}
