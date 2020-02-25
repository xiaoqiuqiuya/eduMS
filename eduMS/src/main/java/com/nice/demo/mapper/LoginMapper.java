package com.nice.demo.mapper;


import com.nice.demo.model.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {
    @Select("select * from t_seehope_teacher where phone=#{account} and password=#{password}")
    Teacher login(@Param("account") String account, @Param("password") String password);
}
