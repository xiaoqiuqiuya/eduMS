package com.nice.demo.service;

import com.nice.demo.dto.StudentDto;
import com.nice.demo.mapper.ClassMapper;
import com.nice.demo.mapper.StudentMapper;
import com.nice.demo.mapper.TeacherMapper;
import com.nice.demo.model.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    ClassMapper classMapper;

//    获取所有的学生
    public List<StudentDto> getStudnets(String content, String status, int page, int limit) {

        page = (page-1)*limit;
        List<Student> students =  studentMapper.getStudents(content,status,page,limit);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student:students){
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student,studentDto);
//            赋值
            if (student.getContractteacherid() != 0) {
                String contractteacher = teacherMapper.getTeacherByID(student.getContractteacherid()).getName();
                studentDto.setContractteacher(contractteacher);
            } else {
                studentDto.setContractteacher("待定");
            }
            if (student.getClassid() != 0) {
                studentDto.setClassName(classMapper.getClassById(student.getClassid()).getName());
            } else {
                studentDto.setClassName("待定");

            }
            if (student.getContractteacherid() != 0) {
                studentDto.setContractteacher(teacherMapper.getTeacherByID(student.getContractteacherid()).getName());
            } else {
                studentDto.setContractteacher("暂无");
            }
            studentDtos.add(studentDto);

        }
        return studentDtos;
    }

//    获取学生总数
    public int getStudnetsCount(String content, String status) {
        return studentMapper.getStudentsCount(content,status);
    }

//    添加学生
    public int addStudent(Student student) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        student.setCreatetime(time);
        return studentMapper.addStudent(student);
    }
}
