package com.jykj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jykj.user.dto.vo.FerChartHumidityVo;
import com.jykj.user.dto.vo.FerChartVo;
import com.jykj.user.entity.FermentationDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FerChartMapper extends BaseMapper<FermentationDetail> {
    List<FerChartVo> getFerChartTemperatureList(@Param("fid")long fid);

    List<FerChartHumidityVo> getFerChartHumidityList(@Param("fid")long fid);
}
