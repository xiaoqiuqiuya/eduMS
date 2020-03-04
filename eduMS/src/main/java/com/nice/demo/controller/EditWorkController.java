package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.model.Work;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EditWorkController {

    @Autowired
    ClassService classService;


    @RequestMapping("/doEditWork")
    @ResponseBody
    public JSONObject editWork(@RequestBody(required = false) Work work, @RequestParam(name = "delid", defaultValue = "0") int delid) {
        JSONObject obj = new JSONObject();
//        删除
        if (delid != 0) {
            System.out.println("删除id" + delid);
            int result = classService.delWorkById(delid);
            getRespon(obj, result, "删除");
            return obj;
        }
//        非空判断
        if (work.getPoint() == null || work.getContent() == null || "".equals(work.getPoint()) || "".equals(work.getContent())) {
            obj.put("status", 0);
            obj.put("msg", "知识点或者内容不能为空");
            return obj;
        }
        if (work.getId() != 0) {
//            修改作业
            int result = classService.updateWorkByWid(work);
            getRespon(obj, result, "修改");
        } else {
//            添加新的作业
            int result = classService.addWork(work);
            getRespon(obj, result, "添加");
        }
        return obj;
    }

    private JSONObject getRespon(JSONObject obj, int result, String option) {
        if (result > 0) {
            obj.put("status", 1);
            obj.put("msg", option + "成功");
        } else {
            obj.put("status", 0);
            obj.put("msg", "添加失败");
        }
        return obj;
    }


}
