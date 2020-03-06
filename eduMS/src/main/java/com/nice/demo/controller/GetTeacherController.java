package com.nice.demo.controller;

import com.nice.demo.model.Teacher;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * 1.个人信息  --返回教师
 * 2.添加教师
 * 3.修改信息  --返回教师
 */

@Controller
public class GetTeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/getTeacher")
    public String getTeacher(@RequestParam("option") String option, @RequestParam(value = "id", defaultValue = "0") int id, HttpServletRequest request, Model model) {
        if (option.equals("aboutMe")) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            model.addAttribute("teacher", teacher);
        }
        if (option.equals("addTeacher")) {
            model.addAttribute("teacher", null);
        }
        if (option.equals("editTeacher")) {
            Teacher teacher = teacherService.getTeacher(id);
            model.addAttribute("teacher", teacher);
        }
        return "editTeacher";
    }

}
