package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.entity.BreedEvaluate;
import com.jykj.user.mapper.BreedEvaluateMapper;
import com.jykj.user.mapper.BreedMapper;
import com.jykj.user.service.IBreedEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
@Service
public class BreedEvaluateServiceImpl extends ServiceImpl<BreedEvaluateMapper, BreedEvaluate> implements IBreedEvaluateService {

    @Autowired
    private BreedMapper breedMapper;
    @Override
    public int createBreedEvaluate(BreedEvaluate breed) {
        Integer cycle = breedMapper.getHowManyDaysApart(breed.getBid());
        breed.setCycle(cycle);
        breed.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreedEvaluate(BreedEvaluate breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedEvaluate> getBreedEvaluateList(long bid, Integer pageSize, Integer pageNum) {
        QueryWrapper<BreedEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bid", bid);
        Page<BreedEvaluate> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPage(page, queryWrapper).getRecords();
    }

    @Override
    public BreedEvaluate getBreedEvaluateById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteEvaluate(long id) {
        return baseMapper.deleteById(id);
    }
}
