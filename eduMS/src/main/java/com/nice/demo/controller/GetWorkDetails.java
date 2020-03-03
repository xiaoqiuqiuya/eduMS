package com.nice.demo.controller;

import com.nice.demo.model.Work;
import com.nice.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GetWorkDetails {

    @Autowired
    ClassService classService;
    /**
     *
     * @param wid   修改的作业id
     * @param model 返回数据用
     * @return
     */
    @RequestMapping("/getWork")
    public String getWork(@RequestParam(value = "wid",defaultValue = "0")int wid,
                           @RequestParam(value = "cid",defaultValue = "0")int cid,
                           Model model){
        if (cid!=0){
            model.addAttribute("work",null);
            model.addAttribute("cid",cid);
//            直接返回
            return "editWork";
        }
//        获取作业信息
      Work work = classService.getClassWorkByWid(wid);
      if (work==null){
          model.addAttribute("msg","当前作业已被删除");
      }else {
      model.addAttribute("work",work);
      }
      return "editWork";
    }
}
