package com.nice.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenController {
    @GetMapping("/")
    public String open() {
        System.out.println("进入登陆页面");
        return "login";
    }
}
