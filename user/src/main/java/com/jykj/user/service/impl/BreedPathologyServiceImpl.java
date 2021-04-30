package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.entity.BreedOperation;
import com.jykj.user.entity.BreedPathology;
import com.jykj.user.mapper.BreedPathologyMapper;
import com.jykj.user.service.IBreedPathologyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-30
 */
@Service
public class BreedPathologyServiceImpl extends ServiceImpl<BreedPathologyMapper, BreedPathology> implements IBreedPathologyService {

    @Override
    public int create(BreedPathology breed) {

        return baseMapper.insert(breed);
    }

    @Override
    public int update(BreedPathology breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public int delete(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<BreedPathology> search(String keyWod, Integer pageSize, Integer pageNum) {
        QueryWrapper<BreedPathology> query= new QueryWrapper<>();
        if(keyWod!=null&& keyWod!=""){
            String key="%"+keyWod+"%";
            query.like("disease",key);
        }
        Page<BreedPathology> page = new Page<>(pageNum, pageSize);
        Page<BreedPathology> data = baseMapper.selectPage(page, query);
        return data.getRecords();
    }
    @Override
    public BreedPathology getBreedPathologyById(long id) {
        QueryWrapper<BreedPathology> query= new QueryWrapper<>();
        BreedPathology data = baseMapper.selectById(id);
        return data;
    }
}
