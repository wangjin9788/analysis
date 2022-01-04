package com.jykj.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.common.api.CommonResult;
import com.jykj.user.common.utils.DateTimeUtil;
import com.jykj.user.controller.BreedTreatmentController;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.BreedDetail;
import com.jykj.user.entity.BreedSummary;
import com.jykj.user.entity.TaskInfo;
import com.jykj.user.mapper.*;
import com.jykj.user.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private BreedDetailMapper detailMapper;

    @Autowired
    private BreedEvaluateMapper evaluateMapper;

    @Autowired
    private BreedMeasureMapper measureMapper;

    @Autowired
    private BreedOperationMapper operationMapper;

    @Autowired
    private BreedSummaryMapper summaryMapper;

    @Autowired
    private BreedTreatmentMapper treatmentMapper;


    @Override
    public int createBreed(Breed breed) {
        int i = baseMapper.insert(breed);
        return i;
    }

    @Override
    public int updateBreed(Breed breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedListVo> getBreedList(Integer status, Integer pageSize, Integer pageNum, Integer type) {
        Page<BreedListVo> page = new Page<>(pageNum, pageSize);

        return baseMapper.getBreedInfoList(page, status, type);
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
        //将数据添加到总结表中
        informationAggregation(id);
        return count;
    }

    @Override
    public Integer deleteBreed(long id) {
        int info = baseMapper.deleteById(id);
        if (info > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("bid", id);
            detailMapper.deleteByMap(map);
            measureMapper.deleteByMap(map);
            operationMapper.deleteByMap(map);
            evaluateMapper.deleteByMap(map);
            treatmentMapper.deleteByMap(map);
        }
        return info;
    }



    private void informationAggregation(long id) {
        BreedSummary info = summaryMapper.informationAggregation(id);
        //查询异常情况
        List<String> list = detailMapper.getDescriptionByBid(id, 1);
        if (list != null && !list.isEmpty()) {
            info.setAbnormal("有异常");
            info.setDescription(JSON.toJSONString(list));
        }
        summaryMapper.insert(info);
    }
}
