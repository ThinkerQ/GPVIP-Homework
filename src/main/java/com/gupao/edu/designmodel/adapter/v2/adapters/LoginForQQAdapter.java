package com.gupao.edu.designmodel.adapter.v2.adapters;

import com.gupao.edu.designmodel.adapter.v1.ResultMsg;

/**
 * Created by King on 2019/3/24.
 */
public class LoginForQQAdapter implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
