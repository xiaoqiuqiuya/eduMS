package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateTeacherStatus {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/updateTeacherStatus")
    @ResponseBody
    public String updateTeacherStatus(@RequestParam(name = "flag",required = false) Boolean flag,
                                      @RequestParam(name = "id") int id,
                                      @RequestParam(name = "del",defaultValue = "false")Boolean del) {

        JSONObject jsonObject = new JSONObject();
        if (del){
            int result =  teacherService.delTeacher(id);
            if (result > 0) {
                jsonObject.put("status",1 );
                jsonObject.put("msg", "删除成功");

            } else {
                jsonObject.put("status", 0);
                jsonObject.put("msg", "删除失败");
            }
            return jsonObject.toString();
        }

        int result = teacherService.updateTeacherStatus(flag,id);
        if (result > 0) {
            jsonObject.put("status", 1);
        } else {
            jsonObject.put("status", 0);
        }
        return jsonObject.toString();

    }
}
