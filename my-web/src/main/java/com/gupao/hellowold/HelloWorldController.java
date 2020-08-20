package com.gupao.hellowold;

import com.gupao.dao.user.entity.UserInnodb;
import com.gupao.hellowold.form.Person;
import com.gupao.module.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
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

    private List<Person> personlist = new ArrayList<>();

    @GetMapping("/heap")
    public String heap(){
        while (true){
            personlist.add(new Person());
        }
    }
}
