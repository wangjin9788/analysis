package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.BreedTreatmentVo;
import com.jykj.user.entity.BreedTreatment;
import com.jykj.user.service.IBreedTreatmentService;
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
@RequestMapping("/breed-treatment")
@Api(tags = "BreedTreatmentController", description = "养殖治疗管理")
public class BreedTreatmentController {

    @Autowired
    private IBreedTreatmentService service;

    @ApiOperation("添加治疗信息")
    @PostMapping(value = "/create")
    public CommonResult createBreedTreatment(@RequestBody BreedTreatment breed) {

        int count = service.createBreedTreatment(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改治疗信息")
    @PostMapping(value = "/update")
    public CommonResult updateBreedTreatment(@RequestBody BreedTreatment breed) {

        int count = service.updateBreedTreatment(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据养殖id获取治疗信息")
    @GetMapping(value = "/list/{id}")
    public CommonResult<List<BreedTreatmentVo>> getBreedTreatmentList(
            @PathVariable(value = "id") long bid,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedTreatmentVo> TreatmentList = service.getBreedTreatmentList( bid,pageSize, pageNum);
        return CommonResult.success(TreatmentList);
    }

    @ApiOperation("根据id获取治疗信息信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedTreatment> getBreedTreatmentById(@PathVariable Long id) {
        BreedTreatment info = service.getBreedTreatmentById(id);
        return CommonResult.success(info);
    }

    @ApiOperation("删除治疗信息信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedTreatment(@PathVariable Long id) {
        Integer count = service.deleteTreatment(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
