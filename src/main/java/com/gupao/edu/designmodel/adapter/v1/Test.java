package com.gupao.edu.designmodel.adapter.v1;

/**
 * 测试类
 * Created by King on 2019/3/24.
 */
public class Test {
    public static void main(String[] args) {
        /*
        * 原有版本的登录接口
         */
        Sigin4Thirdervice sigin4Thirdervice = new Sigin4Thirdervice();
        System.out.println(sigin4Thirdervice.login("king","123123"));
        System.out.println(sigin4Thirdervice.login4QQ("少年强","12313"));

    }
}
