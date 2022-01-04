package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.BatchDetailParam;
import com.jykj.user.dto.PayDataParam;
import com.jykj.user.dto.vo.BreedChartVo;
import com.jykj.user.dto.vo.BreedDetailVo;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.BreedDetail;
import com.jykj.user.entity.ExpPayRevenueCategory;
import com.jykj.user.mapper.BreedDetailMapper;
import com.jykj.user.service.IBreedDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
public class BreedDetailServiceImpl extends ServiceImpl<BreedDetailMapper, BreedDetail> implements IBreedDetailService {

    @Override
    public int createBreedDetail(BreedDetail breed) {
        breed.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreedDetail(BreedDetail breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedDetailVo> getBreedDetailList(long bid, Integer pageSize, Integer pageNum) {
        Page<BreedDetailVo> page = new Page<>(pageNum, pageSize);
        return baseMapper.getBreedDetailInfo(page,bid);
    }

    @Override
    public BreedDetail getBreedDetailById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteBreedDetail(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int batchBreedDetail(List<BatchDetailParam> batchList) {
        List<BatchDetailParam> list = new ArrayList<>();
        for (BatchDetailParam param :
                batchList) {
            if (!StringUtils.isEmpty(param.getSoilHumidity()) && !StringUtils.isEmpty(param.getSoilTemperature())) {
                list.add(param);
            }
        }
        int count = 0;
        if (list.size() > 0 && list != null && !list.isEmpty()) {
            count = baseMapper.batchBreedDetail(batchList);
        }
        return count;
    }

    @Override
    public List<BreedChartVo> getBreedChartTemperature(long id) {
        return baseMapper.getBreedChartTemperature(id);
    }
}
