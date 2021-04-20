package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.service.IFermentationService;
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
@RequestMapping("/fermentation")
@Api(tags = "FermentationController", description = "发酵管理")
public class FermentationController {

    @Autowired
    private IFermentationService service;

    @ApiOperation("创建发酵信息")
    @PostMapping("/create")
    public CommonResult createFermentation(@RequestBody Fermentation fermentation) {
        Integer count = service.createFermentation(fermentation);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑发酵信息")
    @PostMapping("/update")
    public CommonResult updateFermentation(@RequestBody Fermentation fermentation) {
        int count = service.updateFermentation(fermentation);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取发酵信息")
    @GetMapping("/list")
    public CommonResult<List<FermentationDataVo>> getFermentationList(@RequestParam(value = "year", required = false) String year,
                                                                      @RequestParam(value = "month", required = false) String month,
                                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<FermentationDataVo> vo = service.getFermentationList(year, month, pageSize, pageNum);
        return CommonResult.success(vo);
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping("/info/{id}")
    public CommonResult<Fermentation> getFermentationInfo(@RequestParam(value = "id") long id) {
        Fermentation fermentationById = service.getFermentationById(id);
        return CommonResult.success(fermentationById);
    }
}
