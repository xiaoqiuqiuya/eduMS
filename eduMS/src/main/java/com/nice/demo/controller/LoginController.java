package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public JSONObject open(@RequestParam(name = "account") String account,
                       @RequestParam(name = "password") String password,
                       HttpServletRequest request,
                       HttpServletResponse response
                    ) {
        System.out.println("执行登录==account:" + account + "===password:" + password);
//        非空判断
        JSONObject obj = new JSONObject();
        if ("".equals(account) || "".equals(password) || account == null || password == null) {
            obj.put("msg", "账号密码不能为空");
            obj.put("status", "0");
            return obj;
        }
        Teacher teacher = loginService.login(account, password);
        if (teacher == null) {
            System.out.println("账号密码错误");
            obj.put("msg", "账号或者密码错误");
            obj.put("status", "0");
            return obj;
        }
//        将讲师信息保存到session中，方便取用
        request.getSession().setAttribute("teacher",teacher);
//        response.addCookie(new Cookie("teacherID",String.valueOf(teacher.getId())));
        obj.put("status",1);
        System.out.println("登录人："+teacher.getName());
        System.out.println(obj.toString());
        return obj;
    }
}
