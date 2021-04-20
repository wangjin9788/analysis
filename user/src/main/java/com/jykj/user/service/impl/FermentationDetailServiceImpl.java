package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.dto.vo.FermentationDetailDataVo;
import com.jykj.user.entity.FermentationDetail;
import com.jykj.user.mapper.FermentationDetailMapper;
import com.jykj.user.service.IFermentationDetailService;
import org.springframework.stereotype.Service;

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
}
