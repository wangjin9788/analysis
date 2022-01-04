package com.jykj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.BatchFerDetailParam;
import com.jykj.user.dto.vo.FermentationDetailDataVo;
import com.jykj.user.entity.FermentationDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface FermentationDetailMapper extends BaseMapper<FermentationDetail> {

    List<FermentationDetailDataVo> getFermentationDetailList(Page<FermentationDetailDataVo> page, @Param("fid") long fid);

   int batchFerDetail(@Param("list")  List<BatchFerDetailParam> list);
}
