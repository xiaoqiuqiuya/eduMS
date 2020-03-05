package com.nice.demo.dto;

import lombok.Data;

@Data
public class TeacherDto {
    private int id;
    private String createtime;
    private String updatetime;
    private String email;
    private String name;
    private String password;
    private String phone;
    private String qq;
    private String sex;
    private int status;
    private String statusToString;
    private String typeToString;
    private int type;
    private String wechat;
}
