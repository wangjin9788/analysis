package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.entity.FermentationDetail;
import com.jykj.user.mapper.FermentationMapper;
import com.jykj.user.service.IFermentationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        fermentation.setCreateTime(LocalDateTime.now());
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

    @Override
    public Fermentation getFermentationById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int deleteFermentation(long fid) {
        return baseMapper.deleteById(fid);
    }

    @Override
    public int updateFermentationAndSummary(long id) {
        if(id==1){
            return 1;
        }
        Fermentation fermentation = baseMapper.selectById(id);
        fermentation.setStatus(1);
        //修改状态为完成
        return baseMapper.updateById(fermentation);
        //建一张总结表，将数据进行整理
    }
}
