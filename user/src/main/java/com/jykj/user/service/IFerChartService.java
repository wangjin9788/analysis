package com.jykj.user.service;

import com.jykj.user.dto.vo.FerChartHumidityVo;
import com.jykj.user.dto.vo.FerChartVo;
import com.jykj.user.mapper.FerChartMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFerChartService {
    List<FerChartVo> getFerChartTemperatureList(long fid);
    List<FerChartHumidityVo> getFerChartHumidityList(long fid);
}
