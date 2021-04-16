package com.jykj.user.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "ExpPayController", description = "支出统计")
@RequestMapping("/pay-analysis")
public class PayAnalysis {
}
