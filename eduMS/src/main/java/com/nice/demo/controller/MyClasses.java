package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.dto.ClassesDto;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class MyClasses {
    @Autowired
    ClassService classService;

    @GetMapping("/myClass")
    @ResponseBody
    public String myClass(
            @RequestParam(name = "limit",defaultValue = "5") String limit,
            @RequestParam(name = "page",defaultValue = "1") String page,
            @RequestParam(name = "flag",defaultValue = "false") String flag,
            HttpServletRequest request
    ) {
        JSONObject obj = new JSONObject();
//        获取当前登录的用户
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
//        是否显示已经毕业的班级
        List<ClassesDto> classesDtos = classService.getMyClasses(Integer.parseInt(limit),Integer.parseInt( page), teacher.getId(), flag);
        int count = classService.getMyClassesCount(teacher.getId(),flag);
        obj.put("data",classesDtos);
        obj.put("count",count);
        obj.put("code",0);
        return obj.toString();
    }
}
