package com.gupao.dao.user.mapper;

import com.gupao.dao.base.BaseMapper;
import com.gupao.dao.user.entity.UserInnodb;

import java.util.List;

public interface UserInnodbMapper extends BaseMapper<UserInnodb> {

    void insertBatch(List<UserInnodb> userList);
}