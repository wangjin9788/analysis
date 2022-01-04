package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class TaskRelationVo {
    //类型
    private int conType;
    //关联id
    private Long id;
    //编号
    private String  number;
}
