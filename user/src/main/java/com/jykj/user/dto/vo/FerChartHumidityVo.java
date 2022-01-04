package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class FerChartHumidityVo {
    private String date;
    /**
     * 空气湿度
     */
    private float humidity;
    /**
     * 堆内湿度
     */
    private float heapHumidity;
}
