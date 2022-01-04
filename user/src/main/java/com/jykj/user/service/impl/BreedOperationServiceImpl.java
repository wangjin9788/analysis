package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.BreedEvaluate;
import com.jykj.user.entity.BreedOperation;
import com.jykj.user.mapper.BreedMapper;
import com.jykj.user.mapper.BreedOperationMapper;
import com.jykj.user.service.IBreedOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
public class BreedOperationServiceImpl extends ServiceImpl<BreedOperationMapper, BreedOperation> implements IBreedOperationService {
    @Autowired
    private ITaskService taskService;
    @Autowired
    private BreedMapper breedMapper;

    @Override
    public int createBreedOperation(BreedOperation breed) throws ParseException {
        breed.setCreateTime(LocalDateTime.now());
        int count = baseMapper.insert(breed);
        if (count > 0) {
            Breed breedInfo = breedMapper.selectById(breed.getBid());
            taskService.handleTaskByType(breed.getBid(), breed.getType(), breedInfo.getNumber());
        }
        return count;

    }

    @Override
    public int updateBreedOperation(BreedOperation breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedOperation> getBreedOperationList(long bid, Integer pageSize, Integer pageNum, Integer type) {
        QueryWrapper<BreedOperation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bid", bid);
        if (type >= 0) {
            queryWrapper.eq("type", type);
        }
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
