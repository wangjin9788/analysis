package com.jykj.user.dto;

import lombok.Data;

@Data
public class BatchDetailParam {
    /**
     * 养殖id bid
     */
    private Long bid;
    /**
     * 天气id
     */
    private Long wid;
    /**
     * 土壤温度
     */
    private Float soilTemperature;

    /**
     * 土壤湿度
     */
    private Float soilHumidity;
    /**
     * ph值
     */
    private float ph;
    /**
     *异常状态
     */
    private Integer abnormal=0;
    /**
     * 异常说明
     */
    private  String description="";
    /**
     * 检查图片
     */
    private String imgUrl;
}
