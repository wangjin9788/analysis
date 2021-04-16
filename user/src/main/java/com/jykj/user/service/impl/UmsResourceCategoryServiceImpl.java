package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jykj.user.entity.UmsResourceCategory;
import com.jykj.user.mapper.UmsResourceCategoryMapper;
import com.jykj.user.service.IUmsResourceCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 资源分类表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-04
 */
@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements IUmsResourceCategoryService {

    @Override
    public List<UmsResourceCategory> listAll() {
        QueryWrapper<UmsResourceCategory> query= new QueryWrapper<>();
        query.orderByDesc("sort");
        return baseMapper.selectList(query);
    }

    @Override
    public int create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return baseMapper.insert(umsResourceCategory);
    }

    @Override
    public int update(Long id, UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        return baseMapper.updateById(umsResourceCategory);
    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }
}
