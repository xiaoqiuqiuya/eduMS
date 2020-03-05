package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.model.Student;
import com.nice.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddStudent {

    @Autowired
    StudentService studentService;

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(@RequestBody Student student) {
        JSONObject jsonObject = new JSONObject();
        if (student.getName() == null || "".equals(student.getName())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "名字不能为空");
            return jsonObject.toString();
        }
        if (student.getPhone() == null || "".equals(student.getPhone())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "手机号是作为学生登录的依据，不能为空");
            return jsonObject.toString();
        }
        if (student.getIdcard() == null || "".equals(student.getIdcard())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "身份证不能为空");
            return jsonObject.toString();
        }
        if (student.getPassword() == null || "".equals(student.getPassword())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "密码不能为空");
            return jsonObject.toString();
        }

        int result = studentService.addStudent(student);

        if (result>0){
            jsonObject.put("status",1);
            jsonObject.put("msg","添加成功");

        }else{
            jsonObject.put("status",0);
            jsonObject.put("msg","添加失败");
        }
        return jsonObject.toString();
    }
}
