package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.entity.BreedEvaluate;
import com.jykj.user.entity.BreedOperation;
import com.jykj.user.mapper.BreedOperationMapper;
import com.jykj.user.service.IBreedOperationService;
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
public class BreedOperationServiceImpl extends ServiceImpl<BreedOperationMapper, BreedOperation> implements IBreedOperationService {

    @Override
    public int createBreedOperation(BreedOperation breed) {
        breed.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreedOperation(BreedOperation breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedOperation> getBreedOperationList(long bid, Integer pageSize, Integer pageNum) {
        QueryWrapper<BreedOperation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bid", bid);
        Page<BreedOperation> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPage(page, queryWrapper).getRecords();
    }

    @Override
    public BreedOperation getBreedOperationById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteOperation(long id) {
        return baseMapper.deleteById(id);
    }
}
