package com.nice.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MyClasses {

    @GetMapping("/myClass")
    public String myClass(){
        System.out.println("我的班级");
        return "myClass";
    }
}
