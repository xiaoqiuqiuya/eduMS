package com.nice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.nice.demo.dto.Password;
import com.nice.demo.model.Teacher;
import com.nice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UpdatePasswordController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatepassword(@RequestBody Password password,
                                 HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");

        if (password.getPassword()==null||"".equals(password.getPassword())){
            jsonObject.put("status",2);
            jsonObject.put("msg","旧密码不能为空");
            return jsonObject.toString();
        }
        if (password.getPassword1()==null||"".equals(password.getPassword1())){
            jsonObject.put("status",2);
            jsonObject.put("msg","新密码不能为空");
            return jsonObject.toString();
        }
        if (password.getPassword2()==null||"".equals(password.getPassword2())){
            jsonObject.put("status",2);
            jsonObject.put("msg","确认密码不能为空");
            return jsonObject.toString();
        }
        if (!password.getPassword().equals(teacher.getPassword())){

            jsonObject.put("status",0);
            jsonObject.put("msg","旧密码错误,请重新输入");
            return jsonObject.toString();
        }
        if (password.getPassword().equals(password.getPassword1())){
            jsonObject.put("status",0);
            jsonObject.put("msg","新旧密码不能相同");
            return jsonObject.toString();
        }

        if (!password.getPassword1().equals(password.getPassword2())){

            jsonObject.put("status",0);
            jsonObject.put("msg","两次输入的密码不一致，请确认后重新输入");
            return jsonObject.toString();
        }
        int result = teacherService.updateTeacherPassword(password.getPassword1(),teacher.getId());
        if (result>0){

            System.out.println("修改成功:"+password.getPassword1());
//            修改成功，更新session数据
            Teacher teacher1 = teacherService.getTeacher(teacher.getId());
            request.getSession().setAttribute("teacher",teacher1);

            jsonObject.put("status",1);
            jsonObject.put("msg","修改成功");
        }else {
            jsonObject.put("status",0);
            jsonObject.put("msg","修改失败");
        }
        return jsonObject.toString();
    }
}
