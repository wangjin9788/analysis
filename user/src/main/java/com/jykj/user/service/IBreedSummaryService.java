package com.jykj.user.service;

import com.jykj.user.dto.vo.BreedSummaryInfoVo;
import com.jykj.user.entity.BreedSummary;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-28
 */
public interface IBreedSummaryService extends IService<BreedSummary> {
    BreedSummaryInfoVo getBreedSummaryInfo(@Param(value = "bid") long bid);
}
