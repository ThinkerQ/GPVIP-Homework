package com.gupao.common.entity;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/20
 */
public class StringTest {

    String a = "a";
    String b = "ab";
    String c = "a"+"b";
    String d = "b";
    String e = "a"+d;
    final String f = "b";
    final String h = "a";
    String g = h + f;


    public static void main(String[] args) {
        StringTest test = new StringTest();
        System.out.println(test.b==test.c);
        System.out.println(test.e==test.b);
        System.out.println(test.g==test.b);
    }
}
