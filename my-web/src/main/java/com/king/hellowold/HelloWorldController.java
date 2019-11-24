package com.king.hellowold;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/{id}")
    @ResponseBody
    public String hello(@PathVariable String id){
        return "hello world" + id;
    }
}
