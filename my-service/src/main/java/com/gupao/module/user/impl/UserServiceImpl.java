package com.gupao.module.user.impl;

import com.gupao.dao.base.BaseMapper;
import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.dao.user.mapper.UserInnodbMapper;
import com.gupao.module.common.BaseServiceImpl;
import com.gupao.module.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/18
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserInnodb> implements UserService {
    @Autowired
    private UserInnodbMapper userInnodbMapper;

    @Override
    protected BaseMapper<UserInnodb> getBaseMapper() {
        return userInnodbMapper;
    }

    @Override
    public void insertBatch(List<UserInnodb> userList) {
        userInnodbMapper.insertBatch(userList);
    }
}
