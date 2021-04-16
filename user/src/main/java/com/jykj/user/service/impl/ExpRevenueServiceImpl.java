package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.dto.RevenueDataParam;
import com.jykj.user.entity.ExpPayRevenueCategory;
import com.jykj.user.entity.ExpRevenue;
import com.jykj.user.mapper.ExpPayRevenueCategoryMapper;
import com.jykj.user.mapper.ExpRevenueMapper;
import com.jykj.user.service.IExpRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
@Service
public class ExpRevenueServiceImpl extends ServiceImpl<ExpRevenueMapper, ExpRevenue> implements IExpRevenueService {

    @Autowired
   private ExpPayRevenueCategoryMapper categoryMapper;
    @Override
    public int create(ExpRevenue expRevenue) {
        expRevenue.setCreateTime(LocalDateTime.now());
      return baseMapper.insert(expRevenue);
    }

    @Override
    public List<RevenueDataParam> list(String keyword, int pageSize, int pageNum) {

        Page<RevenueDataParam> page= new Page<>(pageNum,pageSize);
        List<RevenueDataParam> revenueList = baseMapper.getRevenueList(page, keyword);
        return revenueList;
    }

    @Override
    public List<ExpPayRevenueCategory> getCategory(){
        QueryWrapper<ExpPayRevenueCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",1);
        List<ExpPayRevenueCategory> expPayRevenueCategories = categoryMapper.selectList(queryWrapper);
        return expPayRevenueCategories;
    }

    @Override
    public int update( ExpRevenue exp) {
        int i = baseMapper.updateById(exp);
        return i;
    }

    @Override
    public ExpRevenue getRevenue(Long id) {
        return baseMapper.selectById(id);

    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }
}
