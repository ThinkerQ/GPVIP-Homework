package com.gupao.common.netty.io.netty.provider;

import com.gupao.common.netty.io.netty.api.IRpcHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
@Slf4j
@Service
public class RpcHelloServieImpl implements IRpcHelloService {
    @Override
    public String hello(String name) {
      log.info("===hello===name={}",name);
      return "Hello: " + name;
    }
}
