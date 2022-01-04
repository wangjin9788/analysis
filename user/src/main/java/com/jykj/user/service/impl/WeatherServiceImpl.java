package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.common.utils.DateTimeUtil;
import com.jykj.user.dto.vo.WeatherInfoVo;
import com.jykj.user.entity.BreedPattern;
import com.jykj.user.entity.Weather;
import com.jykj.user.mapper.WeatherMapper;
import com.jykj.user.service.IWeatherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-12-12
 */
@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherMapper, Weather> implements IWeatherService {

    @Override
    public long createWeather(Weather weather) {
        weather.setCreateTime(LocalDateTime.now());
        int count = baseMapper.insert(weather);
        if (count > 0) {
            return weather.getWid();
        }
        return 0;
    }

    @Override
    public int updateWeather(Weather weather) {
        return baseMapper.updateById(weather);
    }

    @Override
    public int deleteWeather(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<WeatherInfoVo> queryWeather() {

        List<Weather> weathers = baseMapper.queryWeather();
        List<WeatherInfoVo> list = new ArrayList<>();
        if (weathers != null && weathers.size() > 0) {

            for (Weather w :
                    weathers) {
                StringBuffer buffer = new StringBuffer();
                WeatherInfoVo vo= new WeatherInfoVo();
                buffer.append(w.getType()==0?"室内：":"室外：").append("温度：").append(w.getTemperature()).append("->").append("湿度：").append(w.getHumidity()).append("->").append("时间：").append(w.getCreateTime());
                vo.setInfo(buffer.toString());
                vo.setWid(w.getWid());
                list.add(vo);
            }
        }
        return list;
    }

    @Override
    public List<Weather> selectWeather(Integer pageNum, Integer pageSize) {
        Page<Weather> page = new Page<>(pageNum,pageSize);
        return baseMapper.selectPage(page, new QueryWrapper<>()).getRecords();
    }

    @Override
    public Weather getWeatherInfoById(Long wid) {
        return baseMapper.selectById(wid);
    }
}
