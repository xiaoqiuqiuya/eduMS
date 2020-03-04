package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.dto.ClassesDto;
import com.nice.demo.dto.GetClassDto;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class MyClasses {
    @Autowired
    ClassService classService;

    @RequestMapping("/myClass")
    @ResponseBody
    public String myClass(
            @RequestParam(name = "limit",defaultValue = "5") int limit,
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "flag",defaultValue = "false") String flag,
            @RequestParam(name = "content",defaultValue = "%")String content,
            @RequestParam(name = "status",defaultValue = "%")String status,
            @RequestParam(name = "all",defaultValue = "my")String option,
            HttpServletRequest request
    ) {
        JSONObject obj = new JSONObject();
//        获取当前登录的用户
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        GetClassDto getClassDto = new GetClassDto(page,limit,teacher.getId(),flag,content,status,option);
        List<ClassesDto> classesDtos = classService.getMyClasses(getClassDto);
        int count = classService.getMyClassesCount(getClassDto);

        obj.put("data",classesDtos);
        obj.put("count",count);
        obj.put("code",0);
        return obj.toString();
    }
}
