package com.nice.demo.controller;

import com.nice.demo.model.Teacher;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UpdateClassController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/updateClass")
    public String  updateClass(@RequestParam(name = "cid") String cid,
            Model model){

//        获取教师列表
        List<Teacher> tTeachers = teacherService.getTeacherByType();

//        获取班主任列表

        return "updateClass";
    }
}
