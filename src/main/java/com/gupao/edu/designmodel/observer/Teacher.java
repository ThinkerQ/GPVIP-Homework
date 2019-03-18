package com.gupao.edu.designmodel.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2019/3/18.
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void update(Observable observable, Object o) {
        Gper gper = (Gper) observable;
        Question question = (Question) o;
        System.out.println("======观察者订阅开始====");
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("老师您好，").append(question.getName())
                .append("同学提出了问题：【").append(question.getContent()).append("】")
                .append("请抽空解答。");
        System.out.println(sb.toString());
    }
}
