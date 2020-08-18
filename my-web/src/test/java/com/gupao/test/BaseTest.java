/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.gupao.test;

import com.gupao.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 单元测试基类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@ActiveProfiles({"dev"})
@TestExecutionListeners({
        MockitoTestExecutionListener.class})
@EnableTransactionManagement
@EnableWebMvc
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    static {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    public Object unwrapProxy(Object bean) throws Exception {

        return bean;
    }


}
