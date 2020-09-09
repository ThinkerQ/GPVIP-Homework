package com.gupao.common.designpattern;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/9/8
 */
public class SingletonInner {
    private SingletonInner(){}

    /**
     * 只有在第一次调用该方法时虚拟机才会加载并初始哈instance
     * 因为方法是静态的，只有一个对象可以获得对象的初始化锁
     * @return
     */
    public static synchronized SingletonInner getInstance(){
        return Inner.instance;
    }

    /**
     * 静态内部类
     * 虚拟机会保证一个类的构造器在多线程环境中被正确的加载
     */
    private static class Inner {
        private static final SingletonInner instance = new SingletonInner();
    }
}
