package com.gupao.common.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述 测试LinkedList集合在使用for循环和foreach循环下的取值性能差距
 * 结论：当元素大小达到50000个时，普通for循环遍历取值需要花费2477毫秒，增强forEach只需13毫秒，性能差200倍。
 * <p>
 * Created by liZhang on 2020/8/27.
 */
@Slf4j
public class LoopTest {
    public static void main(String[] args) {
//        List<Person> personList = new ArrayList<>();
//        for (long i = 0L; i < 500000; i++) {
//            Person person = new Person(i, "xingming" + i);
//            personList.add(person);
//        }
//
//        for (Person person : personList) {
//            person.setMobilePhone("15006185806");
//        }
////        System.out.println();
////
////        for (int i = 0; i < personList.size(); i++) {
////            Person person = personList.get(i);
////            person.setMobilePhone("15006185806" + i);
////            //personList.set(i, person);
////        }
//
//        System.out.println(personList.get(0).toString());


        //实例化arrayList
        List<Integer> arrayList = new ArrayList<Integer>();
        //实例化linkList
        List<Integer> linkList = new LinkedList<Integer>();

        //插入10万条数据
        int count = 50000;
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
            linkList.add(i);
        }

        int array = 0;
        //用for循环arrayList
        long arrayForStartTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            array = arrayList.get(i);
        }
        long arrayForEndTime = System.currentTimeMillis();
        log.info("用for循环arrayList {}次花费时间：{}" ,count, (arrayForEndTime - arrayForStartTime) + "毫秒");

        //用foreach循环arrayList
        long arrayForeachStartTime = System.currentTimeMillis();
        for(Integer in : arrayList){
            array = in;
        }
        long arrayForeachEndTime = System.currentTimeMillis();
        log.info("用foreach循环arrayList {}次花费时间：{}" ,count, (arrayForeachEndTime - arrayForeachStartTime ) + "毫秒");

        //用for循环linkList
        long linkForStartTime = System.currentTimeMillis();
        int link = 0;


        //用froeach循环linkList
        long linkForeachStartTime = System.currentTimeMillis();
        for(Integer in : linkList){
            link = in;
        }
        long linkForeachEndTime = System.currentTimeMillis();
        log.info("用foreach循环linkList {}次花费时间：{}" ,count, (linkForeachEndTime - linkForeachStartTime ) + "毫秒");

        for (int i = 0; i < linkList.size(); i++) {
            link = linkList.get(i);
        }
        long linkForEndTime = System.currentTimeMillis();
        log.info("用for循环linkList {}次花费时间：{}",count,(linkForEndTime - linkForStartTime) + "毫秒");
    }
}