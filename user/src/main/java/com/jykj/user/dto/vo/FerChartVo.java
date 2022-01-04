package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class FerChartVo {
    private String date;
    /**
     * 气温
     */
    private float temperature;
    /**
     * 堆温
     */
    private float heapTemperature;
    /**
     * 堆湿度
     */
    private float heapHumidity;

}
