package com.gupao.common.designpattern;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/9/8
 */
public class Singleton {
    /**
     * 饿汉式
     */
    private Singleton instance = new Singleton();

    private Singleton(){

    }

    /**
     * 饿汉式 线程安全，缺点：先初始化容易产生垃圾对象
     * @return
     */
    public static Singleton getInstance(){
        return getInstance();
    }
}
