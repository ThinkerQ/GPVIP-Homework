package com.gupao.module.department.impl;

import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.dao.user.mapper.UserInnodbMapper;
import com.gupao.module.department.DepartmentServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/9/7
 */
@Slf4j
@Service
public class DepartmentServieImpl implements DepartmentServie {

    @Autowired
    private UserInnodbMapper userInnodbMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTest2(UserInnodb innodb) {
        //1.同类中的方法调用 a() 调用 b() b方法抛出异常，会导致a回滚吗
        final int count = userInnodbMapper.updateByPrimaryKey(innodb);
        int a = 1/0;
        return count;
    }
}
