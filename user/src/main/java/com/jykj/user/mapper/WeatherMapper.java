package com.jykj.user.mapper;

import com.jykj.user.entity.Weather;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-12-12
 */
public interface WeatherMapper extends BaseMapper<Weather> {
    List<Weather>queryWeather();
}
