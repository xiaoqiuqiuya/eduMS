package com.nice.demo.model;

import lombok.Data;

@Data
public class Classes {
    private int id;
    private String create_time;
    private String update_time;
    private String name;
    private String open_time;
    private String stage;
    private int status;
    private int charge_teacher_id;
    private int teach_teacher_id;
    private int visible;
}
