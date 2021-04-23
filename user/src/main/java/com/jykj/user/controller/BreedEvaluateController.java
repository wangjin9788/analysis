package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.BreedEvaluate;
import com.jykj.user.entity.BreedEvaluate;
import com.jykj.user.service.IBreedEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/breed-evaluate")
@Api(tags = "BreedEvaluateController", description = "养殖评价表")
public class BreedEvaluateController {

    @Autowired
    private IBreedEvaluateService service;

    @ApiOperation("添加评价")
    @PostMapping(value = "/create")
    public CommonResult createBreedEvaluate(@RequestBody BreedEvaluate breed) {

        int count = service.createBreedEvaluate(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改评价")
    @PutMapping(value = "/update")
    public CommonResult updateBreedEvaluate(@RequestBody BreedEvaluate breed) {

        int count = service.updateBreedEvaluate(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据养殖id获取评价")
    @GetMapping(value = "/list/{id}")
    public CommonResult<List<BreedEvaluate>> getBreedEvaluateList(@PathVariable(value = "id") long bId,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedEvaluate> evaluateList = service.getBreedEvaluateList(bId,pageSize,pageNum);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("根据id获取评价信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedEvaluate> getBreedEvaluateById(@PathVariable Long id) {
        BreedEvaluate info = service.getBreedEvaluateById(id);
        return CommonResult.success(info);
    }

    @ApiOperation("删除评价信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedEvaluate(@PathVariable Long id) {
        Integer count = service.deleteEvaluate(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
