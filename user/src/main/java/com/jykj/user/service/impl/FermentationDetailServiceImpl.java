package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.dto.BatchDetailParam;
import com.jykj.user.dto.BatchFerDetailParam;
import com.jykj.user.dto.CompostingTaskParam;
import com.jykj.user.dto.vo.FermentationDetailDataVo;
import com.jykj.user.entity.FermentationDetail;
import com.jykj.user.mapper.FermentationDetailMapper;
import com.jykj.user.service.IFermentationDetailService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
@Service
public class FermentationDetailServiceImpl extends ServiceImpl<FermentationDetailMapper, FermentationDetail> implements IFermentationDetailService {

    @Override
    public int createFermentationDetail(FermentationDetail detail) {
        detail.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(detail);
    }

    @Override
    public int updateFermentationDetail(FermentationDetail detail) {
        return baseMapper.updateById(detail);
    }

    @Override
    public List<FermentationDetailDataVo> getFermentationDetailList(long fid, int pageSize, int pageNum) {
        Page<FermentationDetailDataVo> page = new Page<>(pageNum, pageSize);
        return baseMapper.getFermentationDetailList(page, fid);
    }

    @Override
    public FermentationDetail getFermentationDetailInfo(long fid) {
        return baseMapper.selectById(fid);
    }

    @Override
    public int deleteFermentationDetail(long fid) {
        return baseMapper.deleteById(fid);
    }
    @Override
    public int batchFerDetail(List<BatchFerDetailParam> batchList) {
        List<BatchFerDetailParam> list = new ArrayList<>();
        for (BatchFerDetailParam param :
                batchList) {
            if (!StringUtils.isEmpty(param.getHeapHumidity()) && !StringUtils.isEmpty(param.getHeapTemperature())) {
                list.add(param);
            }
        }
        int count = 0;
        if (list.size() > 0 && list != null && !list.isEmpty()) {
            count = baseMapper.batchFerDetail(batchList);
        }
        return count;
    }

}
