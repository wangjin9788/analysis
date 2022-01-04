package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.dto.vo.FerChartVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.Evaluate;
import com.jykj.user.service.*;
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
@RequestMapping("/breed")
@Api(tags = "BreedController", description = "养殖主表管理")
public class BreedController {

    @Autowired
    private IBreedService service;


    @ApiOperation("添加养殖信息")
    @PostMapping(value = "/create")
    public CommonResult createBreed(@RequestBody Breed breed) {

        int count = service.createBreed(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改养殖信息")
    @PostMapping(value = "/update")
    public CommonResult updateBreed(@RequestBody Breed breed) {

        int count = service.updateBreed(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取养殖信息")
    @GetMapping(value = "/list")
    public CommonResult<List<BreedListVo>> getBreedList(@RequestParam(value = "status", defaultValue = "0") Integer status,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "type", defaultValue = "0") Integer type) {
        List<BreedListVo> evaluateList = service.getBreedList(status,pageSize,pageNum,type);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("根据id获取评价信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<Breed> getBreedById(@PathVariable Long id) {
        Breed value = service.getBreedById(id);
        return CommonResult.success(value);
    }

    @ApiOperation("修改状态和总结")
    @PostMapping("/update-summary/{id}")
    public CommonResult updateBreedStatusAndSummary(@PathVariable long id) {
        Integer count = service.updateBreedStatusAndSummary(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除养殖信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreed(@PathVariable Long id) {
        Integer count = service.deleteBreed(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
