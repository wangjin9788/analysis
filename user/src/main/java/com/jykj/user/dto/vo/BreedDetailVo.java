package com.jykj.user.dto.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BreedDetailVo  {
    private Long bdId;

    /**
     * 养殖主表
     */
    private Long bid;
    /**
     * 气温
     */
    private Float temperature;
    /**
     * 湿度
     */
    private Float humidity;
    /**
     * 土壤温度
     */
    private Float soilTemperature;

    /**
     * 土壤湿度
     */
    private Float soilHumidity;

    /**
     * 异常情况（0：无异常 1：有异常）
     */
    private Integer abnormal;

    /**
     * 异常说明
     */
    private String description;

    /**
     * 异常图片
     */
    private String imgUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * ph值
     */
    private float ph;
}
