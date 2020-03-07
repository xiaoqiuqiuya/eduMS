package com.nice.demo.service;

import com.nice.demo.dto.TeacherDto;
import com.nice.demo.mapper.TeacherMapper;
import com.nice.demo.model.Teacher;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

//    编辑教师
    public int editTeacher(Teacher teacher) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        teacher.setUpdatetime(time);
        int result = 0;

        if (teacher.getId()==0){
//            添加教师
            teacher.setCreatetime(time);
            teacher.setStatus(1);
            result= teacherMapper.addTeacher(teacher);
        }else {
            result = teacherMapper.updateTeacher(teacher);
        }
        return result;

    }

//    修改状态
    public int updateTeacherStatus(Boolean flag,int id) {
        int result = 0;
        if (flag){
            result = teacherMapper.updateTeacherStatus(1,id);
        }else {
            result = teacherMapper.updateTeacherStatus(0,id);

        }
        return result;
    }

//    删除教师
    public int delTeacher(int id) {
        return teacherMapper.delTeacher(id);
    }
//    修改密码
    public int updateTeacherPassword(String password,int id) {
        return teacherMapper.updateTeacherPassword(password,id);
    }
}
