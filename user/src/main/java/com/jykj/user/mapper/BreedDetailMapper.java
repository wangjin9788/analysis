package com.jykj.user.mapper;

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
}
