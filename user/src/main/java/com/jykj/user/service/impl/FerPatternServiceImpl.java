package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.entity.FerPattern;
import com.jykj.user.mapper.FerPatternMapper;
import com.jykj.user.service.IFerPatternService;
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
public class FerPatternServiceImpl extends ServiceImpl<FerPatternMapper, FerPattern> implements IFerPatternService {

    @Override
    public int createFerPattern(FerPattern pattern) {
        return baseMapper.insert(pattern);
    }

    @Override
    public int updateFerPattern(FerPattern pattern) {
        return baseMapper.updateById(pattern);
    }

    @Override
    public List<FerPattern> getFerPatternList() {
        return baseMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public FerPattern getFerPatternById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteFerPatternById(Long id) {
        return baseMapper.deleteById(id);
    }
}
