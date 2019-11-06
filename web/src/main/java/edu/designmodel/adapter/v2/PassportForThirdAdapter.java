package edu.designmodel.adapter.v2;

import edu.designmodel.adapter.v1.ResultMsg;
import edu.designmodel.adapter.v1.SiginService;
import edu.designmodel.adapter.v2.adapters.*;

/**
 * 第三方拓展适配器
 * 结合策略模式，工厂模式，适配器模式
 * Created by King on 2019/3/24.
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird{

    public ResultMsg loginForQQ(String id) {
        return processLogin(id,LoginForQQAdapter.class);
    }

    public ResultMsg loginForWechat(String id){
        return processLogin(id,LoginForWeChat.class);
    }



    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            //适配器不一定要实现接口
            LoginAdapter adapter = clazz.newInstance();

            if (adapter.support(adapter)){
                return adapter.login(key,adapter);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return processLogin(token,LoginForTokenAdapter.class);
    }

    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone,LoginForTelPhoneAdapter.class);
    }

    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username,passport);
        return super.login(username,passport);
    }


}
