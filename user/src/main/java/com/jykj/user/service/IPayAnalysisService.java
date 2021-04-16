package com.jykj.user.service;

import com.jykj.user.dto.PayAnalysisDataParam;

import java.util.List;

public interface IPayAnalysisService {

    List<PayAnalysisDataParam> getPayAndRevenueAnalysis();
}
