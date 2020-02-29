package com.nice.demo.controller;

import com.nice.demo.model.Teacher;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        //判断是否通过修改地址栏直接进入index页面--查看session
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if( teacher==null){
            System.out.println("通过地址栏进来，并没有进行登录");

            return "login";
        }
//        获取名字
        model.addAttribute("name",teacher.getName());
        //返回 templates中 同名为index的文件
        System.out.println("进入index");
        return "index";
    }
}

