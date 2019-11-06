package edu.designmodel.adapter.v2.adapters;

import edu.designmodel.adapter.v1.ResultMsg;

/**
 * 微信登录适配器
 * Created by King on 2019/3/24.
 */
public class LoginForWeChat implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWeChat;
    }

    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
