package com.nice.demo.dto;

import lombok.Data;

@Data
public class GetClassDto {
    private int page;
    private int limit;
    private int teacherId;
    private String flag = "false";
    private String content = "*";
    private String status ="*";
    private String option;

    public GetClassDto(int page, int limit, int teacherId, String flag, String content, String status, String option) {
        this.page = page;
        this.limit = limit;
        this.teacherId = teacherId;
        this.flag = flag;
        this.content = content;
        this.status = status;
        this.option = option;
    }
}
