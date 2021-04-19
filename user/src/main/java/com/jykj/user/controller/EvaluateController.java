package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.Evaluate;
import com.jykj.user.service.IEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/evaluate")
@Api(tags = "EvaluateController", description = "评价管理")
public class EvaluateController {

    @Autowired
    private IEvaluateService service;

    @ApiOperation("添加评价")
    @PostMapping(value = "/create")
    public CommonResult createEvaluate(@RequestBody Evaluate eval) {

        int count = service.createEvaluate(eval);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
