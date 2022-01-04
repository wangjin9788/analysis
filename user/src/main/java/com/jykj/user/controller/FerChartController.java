package com.jykj.user.controller;

import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.FerChartHumidityVo;
import com.jykj.user.dto.vo.FerChartVo;
import com.jykj.user.service.IFerChartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fer_chart")
public class FerChartController {
    @Autowired
    private IFerChartService service;

    @GetMapping("/temperature/{id}")
    @ApiOperation("获取温度列表")
    public CommonResult<List<FerChartVo>> getFerChartTemperatureList(@PathVariable long id){
        List<FerChartVo> temperatureList = service.getFerChartTemperatureList(id);
       return CommonResult.success(temperatureList);
    }
    @GetMapping("/humidity/{id}")
    @ApiOperation("获取温度列表")
    public CommonResult<List<FerChartHumidityVo>> getFerChartHumidityList(@PathVariable long id){
        List<FerChartHumidityVo> temperatureList = service.getFerChartHumidityList(id);
       return CommonResult.success(temperatureList);
    }
}
