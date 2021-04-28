package com.jykj.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.jykj.user.dto.vo.BreedSummaryInfoVo;
import com.jykj.user.entity.BreedSummary;
import com.jykj.user.mapper.BreedSummaryMapper;
import com.jykj.user.service.IBreedSummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-28
 */
@Service
public class BreedSummaryServiceImpl extends ServiceImpl<BreedSummaryMapper, BreedSummary> implements IBreedSummaryService {


    @Override
    public BreedSummaryInfoVo getBreedSummaryInfo(long bid) {
        BreedSummaryInfoVo infoVo = baseMapper.getBreedSummaryInfo(bid);
        if(infoVo!=null&&infoVo.getDescription()!=null){
            List<String> list = JSON.parseArray(infoVo.getDescription(), String.class);
            infoVo.setDescriptionList(list);
        }
        return infoVo;
    }
}
