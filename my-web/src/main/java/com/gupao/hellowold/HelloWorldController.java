package com.gupao.hellowold;

import com.gupao.hellowold.form.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/{id}")
    @ResponseBody
    public String hello(@PathVariable String id){
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
