package edu.designmodel.observer;

/**
 * 测试类
 * Created by Administrator on 2019/3/18.
 */
public class ObserverTest {

    public static void main(String[] args) {
        //创建观察者（老师）
        Teacher tom = new Teacher("Tom");
        Question question = new Question();
        question.setName("耿术强");
        question.setContent("请问观察者模式与适配器模式的区别在哪里？");

        Teacher king = new Teacher("King");
        //创建被观察者（咕泡生态圈）
        Gper gper = Gper.getInstance();
        //给主题添加观察者
        gper.addObserver(tom);
        gper.addObserver(king);
        //发布
        gper.pushQuesetion(question);

    }
}
