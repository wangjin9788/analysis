package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.entity.BreedEvaluate;
import com.jykj.user.entity.BreedMeasure;
import com.jykj.user.mapper.BreedMeasureMapper;
import com.jykj.user.service.IBreedMeasureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
@Service
public class BreedMeasureServiceImpl extends ServiceImpl<BreedMeasureMapper, BreedMeasure> implements IBreedMeasureService {

    @Override
    public int createBreedMeasure(BreedMeasure breed) {
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreedMeasure(BreedMeasure breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedMeasure> getBreedMeasureList(long bid, Integer pageSize, Integer pageNum) {
        QueryWrapper<BreedMeasure> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bid", bid);
        Page<BreedMeasure> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPage(page, queryWrapper).getRecords();
    }

    @Override
    public BreedMeasure getBreedMeasureById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteMeasure(long id) {
        return baseMapper.deleteById(id);
    }
}
