package com.nice.demo.model;

import lombok.Data;

@Data
public class Work {
    private int id;
    private String createtime;
    private String updatetime;
    private String content;
    private String status;
    private String classid;
    private String point;
}
