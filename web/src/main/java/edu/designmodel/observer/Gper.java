package edu.designmodel.observer;

import java.util.Observable;

/**
 * 咕泡观察者
 * 基于JDK观察者
 * Created by Administrator on 2019/3/18.
 */
public class Gper extends Observable {

    private final  String name = "咕泡生态圈";

    //单例
    private static Gper instance = null;

    private Gper() {
    }

    //获取对象：双重检查锁机制
    public static Gper getInstance(){
        if (instance == null){
            synchronized (Gper.class){
                if (instance == null){
                    instance = new Gper();
                }
            }
        }

        return instance;
    }

    public void pushQuesetion(Question question){
        System.out.println("学员[ " + question.getName() +" ]提交了一个问题，问题内容是：" + question.getContent());
        //状态已经改变
        setChanged();
        //通知观察者
        this.notifyObservers(question);
    }
}
