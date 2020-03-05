package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.dto.TeacherDto;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MTeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/mTeacher")
    @ResponseBody
    public String getTeacher(@RequestParam(name = "page", defaultValue = "1") int page,
                             @RequestParam(name = "limit", defaultValue = "5") int limit,
                             @RequestParam(name = "content", defaultValue = "%") String content,
                             @RequestParam(name = "type", defaultValue = "%") String type
    ) {
        JSONObject jsonObject = new JSONObject();
        List<TeacherDto> teacherDtoss = teacherService.getAllTeacher(page, limit, content, type);
        int count = teacherService.getAllTeacherCount(content, type);
        jsonObject.put("data", teacherDtoss);
        jsonObject.put("code",0);
        jsonObject.put("count", count);
        return jsonObject.toString();
    }
}
