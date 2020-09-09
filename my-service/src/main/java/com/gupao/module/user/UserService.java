package com.gupao.module.user;

import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.module.common.BaseService;

import java.util.List;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/18
 */
public interface UserService extends BaseService<UserInnodb> {

    void insertBatch(List<UserInnodb> userList);

    int updateTest(UserInnodb innodb);

    default int a(){
        System.out.println("");
        return 0;
    }

    default int b(){
        System.out.println("");
        return 0;
    }
}
