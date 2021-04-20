package com.jykj.user.dto.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FermentationDetailDataVo {
    //详情id
    private long fdId;
    //主表id
    private long fid;
    //检查时温度
    private float temperature;
    //堆内温度
    private float heapTemperature;
    //当前空气湿度
    private int humidity;
    //堆内湿度
    private int heapHumidity;
    //ph值
    private float ph;
    //原料重量
    private float weight;
    //创建时间
    private Date createTime;
}