package com.nice.demo.mapper;

import com.nice.demo.model.Teacher;
import org.apache.ibatis.annotations.*;

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

//    添加教师
    @Insert("insert into t_seehope_teacher (create_time,update_time,email,name,password,phone,qq,sex,status,type,wechat)" +
            "values (#{createtime},#{updatetime},#{email},#{name},#{password},#{phone},#{qq},#{sex},#{status},#{type},#{wechat})")
    int addTeacher(Teacher teacher);


//    修改教师
    @Update("update t_seehope_teacher set name=#{name},type=#{type},phone=#{phone},password=#{password},wechat=#{wechat}," +
            "email=#{email},qq=#{qq},sex=#{sex} where id=#{id}")
    int updateTeacher(Teacher teacher);

    @Update("update t_seehope_teacher set status=#{status} where id =#{id}")
    int updateTeacherStatus(@Param("status") int status,@Param("id") int id);

//    删除
    @Delete("delete from t_seehope_teacher where id=#{id}")
    int delTeacher(@Param("id") int id);
}
