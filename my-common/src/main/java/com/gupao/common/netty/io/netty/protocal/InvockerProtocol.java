package com.gupao.common.netty.io.netty.protocal;

import lombok.Data;

import java.io.Serializable;

/**
 * Rpc调用协议
 * @Author: GengGhuQiang
 * @Date: 2020/8/13
 */
@Data
public class InvockerProtocol implements Serializable {

    //服务名
    private String className;

    //方法名
    private String methodName;

    //形参列表
    private Class<?> [] params;

    //实参列表
    private Object[] values;
}
