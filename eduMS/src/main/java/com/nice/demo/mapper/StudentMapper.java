package com.nice.demo.mapper;

import com.nice.demo.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from t_seehope_student where name like concat('%',#{content},'%') and status like concat('%',#{status},'%') limit #{page},#{limit}")
    List<Student> getStudents(@Param("content") String content, @Param("status") String status,@Param("page")  int page, @Param("limit") int limit);

    @Select("select count(*) from t_seehope_student where name like concat('%',#{content},'%') and status like concat('%',#{status},'%')")
    int getStudentsCount(@Param("content") String content,@Param("status")  String status);

//    添加学生
    @Insert("insert into t_seehope_student (" +
            "create_time,update_time,IDcard,channel,contract_time,education,email,graduation_time,graduation_where," +
            "information,major,name,password,phone,qq,remark,sex,status,university,wechat,contract_teacher_id) values" +
            "(#{createtime},#{updatetime},#{idcard},#{channel},#{contracttime},#{education},#{email},#{graduationtime},#{graduationwhere}," +
            "#{information},#{major},#{name},#{password},#{phone},#{qq},#{remark},#{sex},0,#{university},#{wechat},#{contractteacherid})")
    int addStudent(Student student);
}
