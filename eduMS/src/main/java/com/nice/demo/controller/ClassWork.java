package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.model.Work;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassWork {
    @Autowired
    ClassService classService;


    @GetMapping("/work")
    @ResponseBody
    public String work(@RequestParam("id")int id,
                       @RequestParam(value = "page",defaultValue = "1")int page,
                       @RequestParam(value = "limit",defaultValue = "5")int limit,

                       Model model){
//        获取作业列表
        List<Work> works = classService.getClassWork(id,page,limit);
        System.out.println("作业条数："+works.size());
        int count = classService.getClassWorkCount(id);
        JSONObject obj = new JSONObject();
        obj.put("count",count);
        obj.put("data",works);
        if (count<=0){
            obj.put("msg","该班级暂时未布置任何作业");
        }
        obj.put("code",0);
        return obj.toString();
    }
}
