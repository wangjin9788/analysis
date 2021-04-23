package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.entity.BreedPattern;
import com.jykj.user.mapper.BreedPatternMapper;
import com.jykj.user.service.IBreedPatternService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class BreedPatternServiceImpl extends ServiceImpl<BreedPatternMapper, BreedPattern> implements IBreedPatternService {

    @Override
    public int createBreedPattern(BreedPattern breed) {
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreedPattern(BreedPattern breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedPattern> getBreedPatternList(Integer pageSize, Integer pageNum) {
        Page<BreedPattern> page = new Page<>(pageNum,pageNum);
        return baseMapper.selectPage(page, new QueryWrapper<>()).getRecords();
    }

    @Override
    public BreedPattern getBreedPatternById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deletePattern(long id) {
        return baseMapper.deleteById(id);
    }
}
