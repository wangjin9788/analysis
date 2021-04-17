package com.jykj.user.service.impl;

import com.jykj.user.dto.vo.PayCategoryPicAnalysisVo;
import com.jykj.user.dto.vo.PayDetailAnalysisVo;
import com.jykj.user.dto.vo.PayRevenuePieAnalysisVo;
import com.jykj.user.mapper.PayAnalysisMapper;
import com.jykj.user.service.IPayAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayAnalysisServiceImpl  implements IPayAnalysisService {

    @Autowired
    private PayAnalysisMapper analysisMapper;


    /**
     * 柱状图---年月日详情统计
     * @return
     */
    @Override
    public List<PayDetailAnalysisVo> getPayAndRevenueAnalysis() {
       return analysisMapper.getPayAndRevenueAnalysis();
    }

    /**
     * 饼状图---年收入支出比例
     * @param time
     * @return
     */
    @Override
    public List<PayRevenuePieAnalysisVo> getPayPicAnalysis(String time) {
        return analysisMapper.getPayPicAnalysis(time);
    }

    /**
     * 饼状图---支出比例统计
     * @param time
     * @return
     */
    @Override
    public List<PayCategoryPicAnalysisVo> getPayCategoryAnalysis(String time) {
        return analysisMapper.getPayCategoryAnalysis(time);
    }
}
