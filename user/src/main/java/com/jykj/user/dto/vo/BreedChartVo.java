package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class BreedChartVo {

    /**
     * 气温
     */
    private Float temperature;
    /**
     * 土壤温度
     */
    private Float soilTemperature;

    /**
     * 土壤湿度
     */
    private Float soilHumidity;
    private String date;
}
