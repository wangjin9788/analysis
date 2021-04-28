package com.jykj.user.mapper;

import com.jykj.user.dto.vo.MeasureAnalysisVo;
import com.jykj.user.entity.BreedMeasure;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface BreedMeasureMapper extends BaseMapper<BreedMeasure> {

    List<MeasureAnalysisVo> getMeasureAnalysis(@Param(value = "bid") long bid);
}
