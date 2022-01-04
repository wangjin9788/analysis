package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.dto.vo.TaskDictionaryVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.entity.TaskDictionary;
import com.jykj.user.service.IFermentationService;
import com.jykj.user.service.ITaskDictionaryService;
import com.jykj.user.service.ITaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    private ITaskDictionaryService taskdService;
    @Autowired
    private IFermentationService service;

    @Autowired
    private ITaskService taskService;


    @ApiOperation("创建发酵信息")
    @PostMapping("/create")
    public CommonResult createFermentation(@RequestBody Fermentation fermentation) throws ParseException {
        Integer count = service.createFermentation(fermentation);
        if (count > 0) {
            return CommonResult.success(fermentation.getFid());
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
    public CommonResult<Fermentation> getFermentationInfo(@PathVariable long id) {
        Fermentation fermentationById = service.getFermentationById(id);
        return CommonResult.success(fermentationById);
    }

    @ApiOperation("删除发酵信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFermentationDetail(@PathVariable Long id) {
        Integer count = service.deleteFermentation(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改状态和总结")
    @PostMapping("/update-summary/{id}")
    public CommonResult updateFermentationDetailAndSummary(@PathVariable long id) {
        Integer count = service.updateFermentationAndSummary(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
