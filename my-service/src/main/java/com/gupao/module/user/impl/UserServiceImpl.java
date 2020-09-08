package com.gupao.module.user.impl;

import com.gupao.dao.base.BaseMapper;
import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.dao.user.mapper.UserInnodbMapper;
import com.gupao.module.common.BaseServiceImpl;
import com.gupao.module.department.DepartmentServie;
import com.gupao.module.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/18
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserInnodb> implements UserService {
    @Autowired
    private UserInnodbMapper userInnodbMapper;

    @Autowired
    private DepartmentServie departmentServie;

    @Override
    protected BaseMapper<UserInnodb> getBaseMapper() {
        return userInnodbMapper;
    }

    @Override
    public void insertBatch(List<UserInnodb> userList) {
        userInnodbMapper.insertBatch(userList);
    }



    @Override
    public int updateTest(UserInnodb innodb) {
        //没有事物的方法调用另一个类中的事物方法b(),b方法抛出异常，会正常回滚,因为b()有事物管理
//        return departmentServie.updateTest2(innodb);
        //没有实物的方法a调用本类中的另一个事物方法b,b发生异常不会导致事物回滚，因为AOP代理的是没有事物管理的a()
        final int count = userInnodbMapper.updateByPrimaryKey(innodb);
        return updateTest2(innodb);
    }


    @Transactional(rollbackFor = Exception.class)
    private int updateTest2(UserInnodb innodb) {
        //1.同类中的方法调用 a() 调用 b() b方法抛出异常，会导致a回滚吗
        int a = 1/0;
        return a;
    }

    public int b(){
        log.info("自定义异常================");
        throw new RuntimeException("自定义异常");
    }
}
