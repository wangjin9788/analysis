package com.jykj.user.dto.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BreedTreatmentVo {
    //id
    private long ptId;
    //详情表编号
    private long bdId;
    //评价
    private String assess;
    //治疗类型
    private String type;
    //病理名称
    private String illnessName;
    //采用药物
    private String medicine;
    //病理说明
    private String illnessExplain;
    //图片
    private  String img;
    //创建时间
    private Date createTime;

}
