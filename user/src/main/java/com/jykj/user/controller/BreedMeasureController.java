package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.BreedMeasure;
import com.jykj.user.service.IBreedMeasureService;
import com.jykj.user.service.IBreedMeasureService;
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
@RequestMapping("/breed-measure")
@Api(tags = "BreedMeasureController", description = "养殖计量管理")
public class BreedMeasureController {

    @Autowired
    private IBreedMeasureService service;

    @ApiOperation("添加计量")
    @PostMapping(value = "/create")
    public CommonResult createBreedMeasure(@RequestBody BreedMeasure breed) {

        int count = service.createBreedMeasure(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改计量")
    @PostMapping(value = "/update")
    public CommonResult updateBreedMeasure(@RequestBody BreedMeasure breed) {

        int count = service.updateBreedMeasure(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据养殖id获取计量")
    @GetMapping(value = "/list/{id}")
    public CommonResult<List<BreedMeasure>> getBreedMeasureList(@PathVariable(value = "id") long bId,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedMeasure> MeasureList = service.getBreedMeasureList(bId,pageSize,pageNum);
        return CommonResult.success(MeasureList);
    }

    @ApiOperation("根据id获取计量信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedMeasure> getBreedMeasureById(@PathVariable Long id) {
        BreedMeasure info = service.getBreedMeasureById(id);
        return CommonResult.success(info);
    }

    @ApiOperation("删除计量信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedMeasure(@PathVariable Long id) {
        Integer count = service.deleteMeasure(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
