package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.BreedOperation;
import com.jykj.user.entity.BreedPathology;
import com.jykj.user.service.IBreedPathologyService;
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
 * @since 2021-04-30
 */
@RestController
@RequestMapping("/breed-pathology")
@Api(tags = "BreedOperationController", description = "病理管理")
public class BreedPathologyController {
    @Autowired
    IBreedPathologyService service;

    @ApiOperation("添加病理操作")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody BreedPathology breed) {

        int count = service.create(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改病理操作")
    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody BreedPathology breed) {

        int count = service.update(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除养殖病理信息")
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        Integer count = service.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据关键字获取信息")
    @GetMapping(value = "/list")
    public CommonResult<List<BreedPathology>> getList(@RequestParam(value = "keyword") String keyword,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedPathology> OperationList = service.search(keyword,pageSize,pageNum);
        return CommonResult.success(OperationList);
    }
    @ApiOperation("根据id获取养殖操作信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedPathology> getBreedPathologyById(@PathVariable Long id) {
        BreedPathology info = service.getBreedPathologyById(id);
        return CommonResult.success(info);
    }
}
