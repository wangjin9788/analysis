package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.BreedOperation;
import com.jykj.user.service.IBreedOperationService;
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
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/breed-operation")
@Api(tags = "BreedOperationController", description = "养殖操作管理")
public class BreedOperationController {
    @Autowired
    private IBreedOperationService service;

    @ApiOperation("添加养殖操作")
    @PostMapping(value = "/create")
    public CommonResult createBreedOperation(@RequestBody BreedOperation breed) {

        int count = service.createBreedOperation(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改养殖操作")
    @PostMapping(value = "/update")
    public CommonResult updateBreedOperation(@RequestBody BreedOperation breed) {

        int count = service.updateBreedOperation(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据养殖操作id获取养殖操作")
    @GetMapping(value = "/list/{id}")
    public CommonResult<List<BreedOperation>> getBreedOperationList(@PathVariable(value = "id") long bId,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedOperation> OperationList = service.getBreedOperationList(bId, pageSize, pageNum);
        return CommonResult.success(OperationList);
    }

    @ApiOperation("根据id获取养殖操作信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedOperation> getBreedOperationById(@PathVariable Long id) {
        BreedOperation info = service.getBreedOperationById(id);
        return CommonResult.success(info);
    }

    @ApiOperation("删除养殖操作信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedOperation(@PathVariable Long id) {
        Integer count = service.deleteOperation(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
