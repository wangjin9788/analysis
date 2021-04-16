package com.jykj.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.entity.UmsResource;
import com.jykj.user.mapper.UmsResourceMapper;
import com.jykj.user.service.IUmsResourceService;
import com.jykj.user.service.UmsAdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-04
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements IUmsResourceService {

    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public int create(UmsResource umsResource) {
        umsResource.setCreateTime(new Date());
       return baseMapper.insert(umsResource);
    }

    @Override
    public int update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        int count = baseMapper.updateById(umsResource);
        adminCacheService.delResourceListByResource(id);
        return count;
    }

    @Override
    public UmsResource getItem(Long id) {

        return baseMapper.selectById(id);
    }

    @Override
    public int delete(Long id) {
        int count = baseMapper.deleteById(id);
        adminCacheService.delResourceListByResource(id);
        return count;
    }

    @Override
    public Page<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        QueryWrapper<UmsResource> query = new QueryWrapper<>();
        Page<UmsResource> page = new Page<>(pageNum,pageSize);

        if(StrUtil.isNotEmpty(nameKeyword)){
            query.like("name",'%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            query.like("url",'%'+urlKeyword+'%');
        }
        return baseMapper.selectPage(page,query);
    }

    @Override
    public List<UmsResource> listAll() {
        return baseMapper.selectList(new QueryWrapper<>());
    }
}
