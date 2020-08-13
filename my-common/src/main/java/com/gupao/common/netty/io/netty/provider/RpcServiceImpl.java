package com.gupao.common.netty.io.netty.provider;

import com.gupao.common.netty.io.netty.api.IRpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
@Slf4j
@Service
public class RpcServiceImpl implements IRpcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
