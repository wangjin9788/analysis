package com.jykj.user.mapper;

import com.jykj.user.dto.vo.BreedSummaryInfoVo;
import com.jykj.user.entity.BreedSummary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-28
 */
public interface BreedSummaryMapper extends BaseMapper<BreedSummary> {

  BreedSummary informationAggregation(@Param(value = "bid") long bid);

  BreedSummaryInfoVo getBreedSummaryInfo(@Param(value = "bid") long bid);
}
