package com.gupao.edu.designmodel.adapter.v1;

/**
 * 登录接口
 * Created by King on 2019/3/24.
 */
public class SiginService {

    /**
     * 注册
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg regist(String userName,String password){
        return new ResultMsg(200,"注册成功",null);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg login(String userName,String password){
        return new ResultMsg(200,"登录成功",null);
    }


}
