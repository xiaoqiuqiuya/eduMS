package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.dto.StudentDto;
import com.nice.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MStudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/getStudent")
    @ResponseBody
    public String getStudent(@RequestParam(name = "content",defaultValue = "%")String  content,
                             @RequestParam(name = "status",defaultValue = "%")String status,
                             @RequestParam(name = "page",defaultValue = "1")int page,
                             @RequestParam(name = "limit",defaultValue = "15")int limit
                             ){
        JSONObject jsonObject = new JSONObject();
        List<StudentDto> studentDtos = studentService.getStudnets(content,status,page,limit);
        int count = studentService.getStudnetsCount(content,status);
        jsonObject.put("data",studentDtos);
        jsonObject.put("count",count);
        jsonObject.put("code",0);
        return jsonObject.toString();
    }
}
