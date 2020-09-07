package com.gupao.hellowold;

import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.hellowold.form.Person;
import com.gupao.module.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWorldController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public String hello(@PathVariable String id){
        UserInnodb user1 = new UserInnodb();
        user1.setId(1);
        userService.updateSelective(user1);
        System.out.println("=====end");

        return "hello world:" + id;
    }


    /**
     * 测试事物管理AOP机制
     * @param id
     * @return
     */
    @RequestMapping("/trs/{id}")
    @ResponseBody
    public String helloTrs(@PathVariable String id){
        UserInnodb innodb = new UserInnodb();
        innodb.setId(1000001);
        innodb.setName("耿术强3");
        //该接口本身没有事物，但是它调用了另外一个有事物的B()方法，请问B()方法发生异常后事物是否会回滚？
        final int test = userService.updateTest(innodb);
        log.info("===test={}",test);
        return "hello world:" + test;
    }


    private List<Person> personlist = new ArrayList<>();

    @GetMapping("/heap")
    public String heap(){
        while (true){
            personlist.add(new Person());
        }
    }
}
