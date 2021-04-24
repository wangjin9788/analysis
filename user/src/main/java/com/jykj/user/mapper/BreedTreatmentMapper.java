package com.jykj.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.vo.BreedTreatmentVo;
import com.jykj.user.entity.BreedTreatment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface BreedTreatmentMapper extends BaseMapper<BreedTreatment> {

    List<BreedTreatmentVo> getBreedTreatmentList(Page<BreedTreatmentVo> page, long bid);
}
