package com.nice.demo.mapper;

import com.nice.demo.model.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {

    //    获取我的所有班级
    @Select("select * from t_seehope_class where teach_teacher_id=#{id} limit #{begin},#{limit}")
    List<Classes> getMyClasses(@Param("begin") int begin, @Param("limit") int limit, @Param("id") int id);

    //    不显示已经毕业的班级
    @Select("select * from t_seehope_class where teach_teacher_id=#{id} and status !=3 limit #{begin},#{limit}")
    List<Classes> getMyClassesNo(@Param("begin") int begin, @Param("limit") int limit, @Param("id") int id);

    //    获取我的所有班级的总数
    @Select("select count(*) from t_seehope_class where teach_teacher_id=#{id}")
    int getMyClassesCount(@Param("id") int id);

    //不显示已经毕业的班级的总数
    @Select("select count(*) from t_seehope_class where teach_teacher_id=#{id} and status !=3")
    int getMyClassesCountNo(@Param("id") int id);
}
