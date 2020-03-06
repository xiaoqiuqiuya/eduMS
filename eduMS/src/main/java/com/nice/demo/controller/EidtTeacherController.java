package com.nice.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EidtTeacherController {
    /**
     * 添加
     * 修改
     */

    @Autowired
    TeacherService teacherService;


    @RequestMapping("/editTeacher")
    @ResponseBody
    public String editTeacher(@RequestBody Teacher teacher) {

        JSONObject jsonObject = new JSONObject();



        if (teacher.getName() == null || "".equals(teacher.getName())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "名字不能为空");
            return jsonObject.toString();
        }

        if (teacher.getPhone() == null || "".equals(teacher.getPhone())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "手机不能为空");
            return jsonObject.toString();
        }
        if(teacher.getId()==0){
            if (teacher.getPassword()==null||"".equals(teacher.getPassword())) {
                jsonObject.put("status", 0);
                jsonObject.put("msg", "密码不能为空");
                return jsonObject.toString();
            }
        }

        int result = teacherService.editTeacher(teacher);

        if (result > 0) {
            jsonObject.put("status", 1);
        } else {
            jsonObject.put("status", 0);
        }

        return jsonObject.toString();

    }

}
