package com.jykj.user.dto;

import lombok.Data;

@Data
public class BatchFerDetailParam {
    /**
     * 养殖id bid
     */
    private Long fid;
    /**
     * 天气id
     */
    private Long wid;
    /**
     * 发酵堆温度
     */
    private Float heapTemperature;

    /**
     * 发酵堆湿度
     */
    private Float heapHumidity;
    /**
     * ph值
     */
    private float ph;
}
