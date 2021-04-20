package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.FermentationDetailDataVo;
import com.jykj.user.entity.FermentationDetail;
import com.jykj.user.service.IFermentationDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/fermentation-detail")
@Api(tags = "FermentationDetailController", description = "发酵详情管理")
public class FermentationDetailController {

    @Autowired
    private IFermentationDetailService service;

    @ApiOperation("创建发酵信息")
    @PostMapping("/create")
    public CommonResult createFermentationDetail(@RequestBody FermentationDetail detail) {
        Integer count = service.createFermentationDetail(detail);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑发酵信息")
    @PostMapping("/update")
    public CommonResult updateFermentationDetail(@RequestBody FermentationDetail detail) {
        Integer count = service.updateFermentationDetail(detail);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据主表id获取发酵详情信息")
    @GetMapping("/list")
    public CommonResult<List<FermentationDetailDataVo>> getFermentationDetailList(@RequestParam(value = "fid", required = false) Long fid,
                                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FermentationDetailDataVo> vo = service.getFermentationDetailList(fid, pageSize, pageNum);
        return CommonResult.success(vo);
    }
}
