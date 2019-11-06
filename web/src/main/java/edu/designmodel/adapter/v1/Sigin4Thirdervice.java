package edu.designmodel.adapter.v1;

/**
 * 第三方登录服务
 * Created by King on 2019/3/24.
 */
public class Sigin4Thirdervice extends SiginService{

    /**
     * 注册完成之后登录
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg login4Regist(String userName,String password){
        super.regist(userName,password);
        return super.login(userName,password);
    }

    /**
     * QQ登录
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg login4QQ(String userName,String password){
        return login4Regist(userName, password);
    }

    /**
     * 微信登录
     * @param openId
     * @return
     */
    public ResultMsg login4WeChat(String openId){
        return null;
    }

    /**
     * 使用token登录
     * @param token
     * @return
     */
    public ResultMsg login4Token(String token){
        return null;
    }

    /**
     * 手机登录
     * @param phone
     * @param code
     * @return
     */
    public ResultMsg login4TelPhone(String phone,String code){
        return null;
    }



}
