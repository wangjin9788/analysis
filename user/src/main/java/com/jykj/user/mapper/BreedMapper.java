package com.jykj.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface BreedMapper extends BaseMapper<Breed> {
    List<BreedListVo> getBreedInfoList(Page<BreedListVo> page, @Param(value = "status") String status);
}
