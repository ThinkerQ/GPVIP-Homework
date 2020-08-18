package com.gupao.test;

import com.gupao.common.utils.NameUtil;
import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.dao.user.mapper.UserInnodbMapper;
import com.gupao.module.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/18
 */
@Slf4j
public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser(){

        UserInnodb user1 = new UserInnodb();
        user1.setId(1);
        userService.updateSelective(user1);
        System.out.println("=====end");
        /*for (int i = 0; i < 2; i++) {
            UserInnodb user = new UserInnodb();
            user.setName(NameUtil.getRandomName(i));
            user.setPhone("18211674995");
            user.setGender(i%2 == 0);
            userService.insertSelective(user);
        }*/

    }
}
