package com.nice.demo.service;

import com.nice.demo.mapper.TeacherMapper;
import com.nice.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    public Teacher getTeacher(int teacherID) {
       return teacherMapper.getTeacherByID(teacherID);
    }
}
