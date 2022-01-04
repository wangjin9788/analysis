package com.jykj.user.service;

import com.jykj.user.dto.vo.WeatherInfoVo;
import com.jykj.user.entity.Weather;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-12-12
 */
public interface IWeatherService extends IService<Weather> {
   long createWeather( Weather weather);

   int updateWeather( Weather weather);

   int deleteWeather(@PathVariable Long id);
   List<WeatherInfoVo> queryWeather();

   List<Weather> selectWeather(Integer pageNum,Integer pageSize);

   Weather getWeatherInfoById(Long wid);

}
