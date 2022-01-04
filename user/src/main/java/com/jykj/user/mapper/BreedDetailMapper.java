package com.jykj.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.BatchDetailParam;
import com.jykj.user.dto.vo.BreedChartVo;
import com.jykj.user.dto.vo.BreedDetailVo;
import com.jykj.user.entity.BreedDetail;
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
public interface BreedDetailMapper extends BaseMapper<BreedDetail> {

    List<String> getDescriptionByBid(@Param(value = "bid")long bid, @Param(value = "abnormal") int abnormal);

    int batchBreedDetail(@Param(value = "list")List<BatchDetailParam> list);

    List<BreedDetailVo> getBreedDetailInfo(Page<BreedDetailVo> page, @Param(value = "bid")long bid);

    List<BreedChartVo>getBreedChartTemperature(@Param(value = "id")long id);
}
