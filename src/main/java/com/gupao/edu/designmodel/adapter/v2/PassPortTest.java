package com.gupao.edu.designmodel.adapter.v2;

/**
 * Created by King on 2019/3/24.
 */
public class PassPortTest {
    public static void main(String[] args) {
        //使用适配器模式兼容旧的登录接口和新的第三方登录接口
        IPassportForThird passportForThird = new PassportForThirdAdapter();
        passportForThird.loginForRegist("king","123123");
    }
}
