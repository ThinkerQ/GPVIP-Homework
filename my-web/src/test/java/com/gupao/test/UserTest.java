package com.gupao.test;

import com.gupao.common.utils.NameUtil;
import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.dao.user.mapper.UserInnodbMapper;
import com.gupao.module.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/18
 */
@Slf4j
public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Rollback(value = false)
    @Test
    public void updateUser(){
        UserInnodb innodb = new UserInnodb();
        innodb.setId(1000001);
        innodb.setName("耿术强2");
        final int test = userService.updateTest(innodb);
        log.info("===test={}",test);
    }

    @Rollback(value = false)
    @Test
    public void addUser(){

        int num = 1000000;
        List<UserInnodb> userList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            UserInnodb user = new UserInnodb();
            user.setName(NameUtil.getRandomName(i));
            user.setPhone(NameUtil.getTel());
            user.setGender(i%2 == 0);
            userList.add(user);
            if(i != 0 && i%10000 == 0){
                System.out.println("====插入批次："+i/10000);
                userService.insertBatch(userList);
                userList = new ArrayList<>();
            }
        }

        System.out.println("=====end");
    }
}
