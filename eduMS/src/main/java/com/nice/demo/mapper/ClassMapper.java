package com.nice.demo.mapper;

import com.nice.demo.dto.GetClassDto;
import com.nice.demo.model.Classes;
import com.nice.demo.model.Student;
import com.nice.demo.model.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {
//
//    //    获取我的所有班级
//    @Select("select * from t_seehope_class where teach_teacher_id=#{id} limit #{begin},#{limit}")
//    List<Classes> getMyClasses(@Param("begin") int begin, @Param("limit") int limit, @Param("id") int id);
//
//    //    不显示已经毕业的班级
//    @Select("select * from t_seehope_class where teach_teacher_id=#{id} and status !=3 limit #{begin},#{limit}")
//    List<Classes> getMyClassesNo(@Param("begin") int begin, @Param("limit") int limit, @Param("id") int id);

    //    获取我的所有班级的总数
    @Select("select count(*) from t_seehope_class where teach_teacher_id=#{id}")
    int getMyClassesCount(@Param("id") int id);

    //    不显示已经毕业的班级的总数
    @Select("select count(*) from t_seehope_class where teach_teacher_id=#{id} and status !=3")
    int getMyClassesCountNo(@Param("id") int id);

    //    根据id获取班级信息
    @Select("select * from t_seehope_class where id = #{cid}")
    Classes getClassById(@Param("cid") int cid);

    //    修改班级信息
    @Update("update t_seehope_class set update_time=#{updatetime},name=#{name},open_time=#{opentime}," +
            "stage=#{stage},status=#{status},charge_teacher_id=#{chargeteacherid},teach_teacher_id=#{teachteacherid} where id=#{id}")
    int updateClass(Classes classes);

    //    删除班级
    @Delete("delete from t_seehope_class where id = #{id}")
    int delClass(@Param("id") int id);

    //    添加班级
    @Insert("insert into t_seehope_class (create_time,update_time,name,open_time,stage,status,charge_teacher_id,teach_teacher_id,visible)" +
            " values (#{createtime},#{updatetime},#{name},#{opentime},#{stage},#{status},#{chargeteacherid},#{teachteacherid},#{visible})")
    int addClass(Classes classes);

    //    获取班级作业
    @Select("select * from t_class_work where class_id=#{id} limit #{page},#{limit}")
    List<Work> getClassWork(@Param("id") int id, @Param("page") int page, @Param("limit") int limit);

    //    获取班级作业总数
    @Select("select count(*) from t_class_work where class_id=#{id}")
    int getClassWorkCount(int id);

    //    获取作业详细信息
    @Select("select * from t_class_work where id=#{wid}")
    Work getClassWorkByWid(@Param("wid") int wid);

    //    修改作业信息
    @Update("update t_class_work set point=#{point},content=#{content},update_time=#{updatetime} where id=#{id}")
    int updateWorkByWid(Work work);

    //    删除作业
    @Delete("delete from t_class_work where id=#{delId}")
    int delWorkById(int delId);

    //    添加作业
    @Insert("insert into t_class_work (create_time,update_time,content," +
            "status,class_id,point) values (#{createtime},#{updatetime}," +
            "#{content},#{status},#{classid},#{point})")
    int addWork(Work work);

    //    获取班级学生
    @Select("select * from t_seehope_student where class_id=#{id} limit #{page},#{limit}")
    List<Student> getClassStdent(@Param("id") int id, @Param("page") int page, @Param("limit") int limit);

    //    获取我的所有班级
    @Select("select * from t_seehope_class where teach_teacher_id=#{teacherId} limit #{page},#{limit}")
    List<Classes> getMyClasses(GetClassDto getClassDto);
//获取我的班级，不显示已经毕业的班级
    @Select("select * from t_seehope_class where teach_teacher_id=#{teacherId} and status !=3 limit #{page},#{limit}")
    List<Classes> getMyClassesNo(GetClassDto getClassDto);

    //    获取所有班级
    @Select("select * from t_seehope_class where name like concat('%',#{content},'%') and status like concat('%',#{status},'%') limit #{page},#{limit}")
    List<Classes> getAllClasses(GetClassDto getClassDto);

//    获取班级数据
    @Select("select count(*) from t_seehope_class where name like concat('%',#{content},'%') and status like concat('%',#{status},'%')")
    int getclassCount(GetClassDto getClassDto);

//    获取班级学生总数
    @Select("select count(*) from t_seehope_student where class_id=#{id}")
    int getCLassStudentCount(@Param("id") int id);

//    List<Classes> getAllClasses(int , int );
}
