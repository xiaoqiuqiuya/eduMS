package com.nice.demo.service;

import com.nice.demo.dto.ClassesDto;
import com.nice.demo.mapper.ClassMapper;
import com.nice.demo.mapper.TeacherMapper;
import com.nice.demo.model.Classes;
import com.nice.demo.model.Teacher;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    ClassMapper classMapper;
    private Teacher tTeacher;
    public List<ClassesDto> getMyClasses(int limit, int page, int id, String flag) {
        List<ClassesDto> classesDtos = new ArrayList<>();
        List<Classes> classes = new ArrayList<>();
//        计算分页
        int begin = (page - 1) * limit;
        if (flag.equals("true")) {
//            显示所有我的班级
            classes = classMapper.getMyClasses(begin, limit, id);
        } else {
//            不显示已经毕业的班级
            classes = classMapper.getMyClassesNo(begin, limit, id);
        }
        for (Classes classes1 : classes) {
            ClassesDto classesDto = new ClassesDto();
            BeanUtils.copyProperties(classes1, classesDto);
//            设置教师名字
            Teacher tTeacher = teacherMapper.getTeacherByID(classes1.getTeachteacherid());
            if (tTeacher != null) {
                classesDto.setTeachteacher(tTeacher.getName());
            } else {
                classesDto.setChargeteacher("待定教师");
            }
//            设置班主任名字
            Teacher cTeacher = teacherMapper.getTeacherByID(classes1.getChargeteacherid());
            if (cTeacher != null) {
                classesDto.setChargeteacher(cTeacher.getName());
            } else {
                classesDto.setChargeteacher("待定班主任");
            }
//            设置状态
            if (classes1.getStatus() == 1) {
                classesDto.setStatus("预开班");
            } else if (classes1.getStatus() == 2) {
                classesDto.setStatus("已开班");
            } else {
                classesDto.setStatus("已毕业");
            }
            classesDtos.add(classesDto);
        }
        return classesDtos;
    }
    //    获取我的班级的数目
    public int getMyClassesCount(int id, String flag) {
        if (flag.equals("true")) {
//            显示所有我的班级
            return classMapper.getMyClassesCount(id);
        } else {
//            不显示已经毕业的班级
            return classMapper.getMyClassesCountNo(id);
        }
    }
}
