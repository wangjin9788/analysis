package com.jykj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jykj.user.dto.BatchFerDetailParam;
import com.jykj.user.dto.CompostingTaskParam;
import com.jykj.user.dto.vo.FermentationDetailDataVo;
import com.jykj.user.entity.FermentationDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface IFermentationDetailService extends IService<FermentationDetail> {
    int createFermentationDetail(FermentationDetail detail);

    int updateFermentationDetail(FermentationDetail detail);

    List<FermentationDetailDataVo> getFermentationDetailList(long fid, int pageSize, int pageNum);

    FermentationDetail getFermentationDetailInfo(long fid);

    int deleteFermentationDetail(long fid);

    int batchFerDetail(List<BatchFerDetailParam> batchList);



}
