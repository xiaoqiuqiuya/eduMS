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
    public String edit(@RequestBody(required = false) Classes classes, @RequestParam(name = "id", defaultValue = "0") int id) {
        JSONObject obj = new JSONObject();
        if (classes == null && id != 0) {
//            删除操作
            int result = classService.delClass(id);
            obj = getResponse(obj, result, "删除");
            return obj.toString();
        }
        if (classes.getName() == null || "".equals(classes.getName())) {
            obj.put("status", 0);
            obj.put("msg", "班级名称不能为空");
            return obj.toString();
        }
        if (classes.getId() == 0) {//添加班级
            int result = classService.addClass(classes);
            obj = getResponse(obj, result, "添加");
            return obj.toString();
        } else {//修改班级
            int result = classService.updateClass(classes);
            obj = getResponse(obj, result, "修改");
            return obj.toString();
        }

    }
    private JSONObject getResponse(JSONObject obj, int result, String option) {
        if (result > 0) {
            obj.put("status", 1);
            obj.put("msg", option + "成功");
        } else {
            obj.put("status", 0);
            obj.put("msg", option + "失败");
        }
        return obj;
    }
}
