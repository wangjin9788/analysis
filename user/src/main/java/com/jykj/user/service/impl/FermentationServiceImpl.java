package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.mapper.FermentationMapper;
import com.jykj.user.service.IFermentationService;
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
public class FermentationServiceImpl extends ServiceImpl<FermentationMapper, Fermentation> implements IFermentationService {

    @Override
    public int createFermentation(Fermentation fermentation) {
        return baseMapper.insert(fermentation);
    }

    @Override
    public int updateFermentation(Fermentation fermentation) {
        return baseMapper.updateById(fermentation);
    }

    @Override
    public List<FermentationDataVo> getFermentationList(String year, String month, Integer pageSize, Integer pageNum) {
        Page<FermentationDataVo> page = new Page<>(pageNum, pageSize);
        List<FermentationDataVo> list = baseMapper.getFermentationList(page, year, month);
        return list;
    }
}
