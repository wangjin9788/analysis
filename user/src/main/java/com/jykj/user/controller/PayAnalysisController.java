package com.jykj.user.controller;

import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.PayAnalysisDataParam;
import com.jykj.user.service.IPayAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "PayAnalysisController", description = "支出统计")
@RequestMapping("/pay-analysis")
public class PayAnalysisController {
    @Autowired
    private IPayAnalysisService payAnalysisService;


    @ApiOperation("支出营收统计营收")
    @GetMapping(value = "/pay_revenue_analysis")
    public CommonResult<List<PayAnalysisDataParam>> getPayAndRevenueAnalysis() {
        List<PayAnalysisDataParam> payAndRevenueAnalysis = payAnalysisService.getPayAndRevenueAnalysis();
        return CommonResult.success(payAndRevenueAnalysis);
    }
}
