package com.jykj.user.service.impl;

import com.jykj.user.dto.vo.FerChartHumidityVo;
import com.jykj.user.dto.vo.FerChartVo;
import com.jykj.user.mapper.FerChartMapper;
import com.jykj.user.service.IFerChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerChartServiceImpl implements IFerChartService {
    @Autowired
    private FerChartMapper chartMapper;
    @Override
    public List<FerChartVo> getFerChartTemperatureList(long fid) {
        List<FerChartVo> list = chartMapper.getFerChartTemperatureList(fid);
        return list;
    }

    @Override
    public List<FerChartHumidityVo> getFerChartHumidityList(long fid) {
        List<FerChartHumidityVo> humidityList = chartMapper.getFerChartHumidityList(fid);
        return humidityList;
    }
}
