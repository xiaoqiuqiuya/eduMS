package com.nice.demo.mapper;

import com.nice.demo.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from t_seehope_teacher where id=#{id}")
    Teacher getTeacherByID(@Param("id") int teacherID);

    //    获取教师列表和班主任列表
    @Select("select * from t_seehope_teacher where type=#{type}")
    List<Teacher> getTeacherByType(@Param("type") int i);

    //    教师管理 获取所有的教师
    @Select("select * from t_seehope_teacher where name like concat('%',#{content},'%') and type like concat('%',#{type},'%') limit #{page},#{limit}")
    List<Teacher> getAllTeacher(@Param("page") int page, @Param("limit") int limit, @Param("content") String content, @Param("type") String type);

    //    获取教师总数
    @Select("select count(*) from t_seehope_teacher where name like concat('%',#{content},'%') and type like concat('%',#{type},'%')")
    int getAllTeacherCount( @Param("content") String content, @Param("type") String type);
}
