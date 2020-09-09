package com.gupao.common.designpattern;

/**
 * 懒汉式（双重检查锁）
 * @Author: GengGhuQiang
 * @Date: 2020/9/8
 */
public class SingletonLazy {
    private volatile static SingletonLazy instance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized(SingletonLazy.class){
                //避免多线程场景下线程安全问题
                if(instance == null){
                    //jvm会进行指令重排序，使用volatile避免重排序，实现可见性
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
