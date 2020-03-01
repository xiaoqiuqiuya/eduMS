package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.model.Classes;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EidtClassesController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/editClass", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody Classes classes) {
        int cid = classes.getId();
        JSONObject obj = new JSONObject();
        if (cid != 0) {
//            修改班级
            int result = classService.updateClass(classes);
            if (result > 0) {
                obj.put("status", 1);
                obj.put("msg", "修改成功");
            } else {
                obj.put("status", 0);
                obj.put("msg", "修改失败");
            }
        } else {
//            添加班级
            System.out.println("cid is null");
        }

        return obj.toString();
    }
}
