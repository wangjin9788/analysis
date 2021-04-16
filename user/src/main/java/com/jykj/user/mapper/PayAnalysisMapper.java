package com.jykj.user.mapper;

import com.jykj.user.dto.PayAnalysisDataParam;

import java.util.List;

public interface PayAnalysisMapper {

    List<PayAnalysisDataParam> getPayAndRevenueAnalysis();
}
