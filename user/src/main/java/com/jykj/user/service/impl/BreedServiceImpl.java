package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.mapper.BreedMapper;
import com.jykj.user.service.IBreedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class BreedServiceImpl extends ServiceImpl<BreedMapper, Breed> implements IBreedService {

    @Override
    public int createBreed(Breed breed) {
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreed(Breed breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedListVo> getBreedList(String status, Integer pageSize, Integer pageNum) {
        Page<BreedListVo> page = new Page<>(pageNum, pageSize);

        return baseMapper.getBreedInfoList(page, status);
    }

    @Override
    public Breed getBreedById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer updateBreedStatusAndSummary(long id) {
        Breed breed = baseMapper.selectById(id);
        breed.setStatus(1);
        int count = baseMapper.updateById(breed);
        return count;
    }

    @Override
    public Integer deleteBreed(long id) {
        return baseMapper.deleteById(id);
    }
}
