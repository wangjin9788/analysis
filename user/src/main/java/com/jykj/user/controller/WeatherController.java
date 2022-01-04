package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.WeatherInfoVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.Weather;
import com.jykj.user.service.IWeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-12-12
 */
@RestController
@RequestMapping("/weather")
@Api(tags = "UmsRoleController", description = "天气管理")
public class WeatherController {
    @Autowired
    private IWeatherService weatherService;

    @ApiOperation("添加天气信息")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Weather weather) {
        long id = weatherService.createWeather(weather);
        return CommonResult.success(id);
    }

    @ApiOperation("查询今天天气")
    @GetMapping("/list")
    public CommonResult<List<WeatherInfoVo>> queryWeather() {
        List<WeatherInfoVo> weathers = weatherService.queryWeather();
        return CommonResult.success(weathers);

    }
    @ApiOperation("查询天气")
    @GetMapping("/query")
    public CommonResult<List<Weather>> selectWeather( @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Weather> weathers = weatherService.selectWeather(pageNum,pageSize);
        return CommonResult.success(weathers);
    }
    @ApiOperation("修改天气信息")
    @PostMapping(value = "/update")
    public CommonResult updateWeather(@RequestBody Weather weather) {
        int count = weatherService.updateWeather(weather);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除养殖信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteWeather(@PathVariable Long id) {
        Integer count = weatherService.deleteWeather(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据id获取天气信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<Weather> getWeatherInfoById(@PathVariable Long id) {
        Weather value = weatherService.getWeatherInfoById(id);
        return CommonResult.success(value);
    }
}
