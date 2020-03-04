package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.dto.StudentDto;
import com.nice.demo.model.Student;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GetClassStudentController {

    @Autowired
    ClassService classService;

    @GetMapping("/getClassStudent")
    @ResponseBody
    public JSONObject getClassStudent(@RequestParam(name = "page", defaultValue = "1") int page,
                                      @RequestParam(name = "limit", defaultValue = "5") int limit,
                                      @RequestParam(name = "id") int id) {
        JSONObject obj = new JSONObject();
        List<StudentDto> studentDtos = classService.getClassStudent(id, page, limit);
        int count = classService.getClassStudentCount(id);
        obj.put("data", studentDtos);
        obj.put("count",count);
        obj.put("code", 0);
        return obj;
    }
}
