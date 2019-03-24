package com.gupao.edu.designmodel.adapter.v2.adapters;

import com.gupao.edu.designmodel.adapter.v1.ResultMsg;

/**
 * 电话登录适配器
 * Created by King on 2019/3/24.
 */
public class LoginForTelPhoneAdapter implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelPhoneAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
