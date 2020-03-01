package com.nice.demo.mapper;

import com.nice.demo.model.Classes;
import org.apache.ibatis.annotations.*;

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

//    根据id获取班级信息
    @Select("select * from t_seehope_class where id = #{cid}")
    Classes getClassById(@Param("cid") String cid);

//    修改班级信息
    @Update("update t_seehope_class set update_time=#{updatetime},name=#{name},open_time=#{opentime}," +
            "stage=#{stage},status=#{status},charge_teacher_id=#{chargeteacherid},teach_teacher_id=#{teachteacherid} where id=#{id}")
    int updateClass(Classes classes);


//  删除班级
    void delClass(int id);
//添加班级
    @Insert("insert into t_seehope_class (id,create_time,update_time,name,open_time,stage,status,charge_teacher_id,teach_teacher_id,visible)" +
            " values (#{id},#{createtime},#{updatetime},#{name},#{opentime},#{stage},#{status},#{chargeteacherid},#{teachteacherid},#{visible})")
    int addClass(Classes classes);
}
