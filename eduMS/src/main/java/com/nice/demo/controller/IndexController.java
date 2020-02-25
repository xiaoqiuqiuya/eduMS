package com.nice.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        //返回 templates中 同名为index的文件
        System.out.println("进入index");
        return "index";
    }
}

