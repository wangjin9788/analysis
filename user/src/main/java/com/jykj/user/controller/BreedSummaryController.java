package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.BreedSummaryInfoVo;
import com.jykj.user.service.IBreedSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/breed-summary")
@Api(tags = "BreedPatternController", description = "养殖总结管理")
public class BreedSummaryController {

    @Autowired
    private IBreedSummaryService service;

    @ApiOperation("根据bid获取总结信息")
    @GetMapping("/summary/{bid}")
    public CommonResult<BreedSummaryInfoVo> getBreedSummaryInfo(@PathVariable(value = "bid") long bid) {
        BreedSummaryInfoVo info = service.getBreedSummaryInfo(bid);
        if (info == null) {
            return CommonResult.failed();
        } else {
            return CommonResult.success(info);
        }
    }
}
