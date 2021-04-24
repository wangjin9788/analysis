package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.vo.BreedTreatmentVo;
import com.jykj.user.entity.BreedTreatment;
import com.jykj.user.mapper.BreedTreatmentMapper;
import com.jykj.user.service.IBreedTreatmentService;
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
public class BreedTreatmentServiceImpl extends ServiceImpl<BreedTreatmentMapper, BreedTreatment> implements IBreedTreatmentService {

    @Override
    public int createBreedTreatment(BreedTreatment breed) {
        breed.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreedTreatment(BreedTreatment breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedTreatmentVo> getBreedTreatmentList(Long bid, Integer pageSize, Integer pageNum) {
        Page<BreedTreatmentVo> page = new Page<>(pageNum,pageSize);
        return baseMapper.getBreedTreatmentList(page,bid);
    }

    @Override
    public BreedTreatment getBreedTreatmentById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteTreatment(long id) {
        return baseMapper.deleteById(id);
    }
}
