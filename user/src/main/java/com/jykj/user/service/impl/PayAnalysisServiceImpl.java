package com.jykj.user.service.impl;

import com.jykj.user.dto.PayAnalysisDataParam;
import com.jykj.user.mapper.PayAnalysisMapper;
import com.jykj.user.service.IPayAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayAnalysisServiceImpl  implements IPayAnalysisService {

    @Autowired
    private PayAnalysisMapper analysisMapper;

    @Override
    public List<PayAnalysisDataParam> getPayAndRevenueAnalysis() {
       return analysisMapper.getPayAndRevenueAnalysis();
    }
}
