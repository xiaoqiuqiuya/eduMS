package com.nice.demo.mapper;

import com.nice.demo.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {

    @Select("select * from t_seehope_teacher where id=#{id}")
    Teacher getTeacherByID(@Param("id") int teacherID);
}
