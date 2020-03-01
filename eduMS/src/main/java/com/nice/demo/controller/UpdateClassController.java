package com.nice.demo.controller;

import com.nice.demo.model.Classes;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.ClassService;
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

    @Autowired
    ClassService classService;

    @GetMapping("/updateClass")
    public String  updateClass(@RequestParam(name = "cid") String cid,
            Model model){
//        获取班级信息
        Classes classes = classService.getClassById(cid);
//        获取教师列表  type = 1
        List<Teacher> tTeachers = teacherService.getTeacherByType(1);
//        获取班主任列表 type = 2
        List<Teacher> cTeachers = teacherService.getTeacherByType(2);
        model.addAttribute("thisClass",classes);
        model.addAttribute("tTeachers",tTeachers);
        model.addAttribute("cTeachers",cTeachers);
        return "updateClass";
    }
}
