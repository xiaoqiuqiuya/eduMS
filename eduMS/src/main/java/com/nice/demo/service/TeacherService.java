package com.nice.demo.service;

import com.nice.demo.dto.TeacherDto;
import com.nice.demo.mapper.TeacherMapper;
import com.nice.demo.model.Teacher;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    public Teacher getTeacher(int teacherID) {
       return teacherMapper.getTeacherByID(teacherID);
    }


    public List<Teacher> getTeacherByType(int i) {
        return teacherMapper.getTeacherByType(i);
    }

//    教师管理
    public List<TeacherDto> getAllTeacher(int page, int limit, String content, String type) {
        page=(page-1)*limit;
        List<TeacherDto> teacherDtos = new ArrayList<>();
        List<Teacher> teachers =  teacherMapper.getAllTeacher(page,limit,content,type);
        for (Teacher teacher:teachers){
            TeacherDto teacherDto = new TeacherDto();
            BeanUtils.copyProperties(teacher,teacherDto);
            if (teacher.getType()==1){
                teacherDto.setTypeToString("讲师");
            }else {
                teacherDto.setTypeToString("班主任");
            }
            if (teacher.getStatus()==1){
                teacherDto.setStatusToString("激活");
            }else {
                teacherDto.setStatusToString("停用");
            }
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }

//    获取教师总数
    public int getAllTeacherCount(String content, String type) {
        return teacherMapper.getAllTeacherCount(content,type);
    }
}
