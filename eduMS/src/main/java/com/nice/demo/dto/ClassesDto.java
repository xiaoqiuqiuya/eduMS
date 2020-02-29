package com.nice.demo.dto;

import lombok.Data;

@Data
public class ClassesDto {
    private int id;
    private String createtime;
    private String updatetime;
    private String name;
    private String opentime;
    private String stage;
    private int chargeteacherid;
    private int teachteacherid;
    private String status;
    private String chargeteacher;
    private String teachteacher;
}
