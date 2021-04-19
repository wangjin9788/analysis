package com.jykj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface FermentationMapper extends BaseMapper<Fermentation> {

    List<FermentationDataVo> getFermentationList(Page<FermentationDataVo> page, String year, String month);

}
