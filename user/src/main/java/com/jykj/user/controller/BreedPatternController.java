package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.BreedPattern;
import com.jykj.user.service.IBreedPatternService;
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
@RequestMapping("/breed-pattern")
@Api(tags = "BreedPatternController", description = "养殖模式管理")
public class BreedPatternController {
    @Autowired
    private IBreedPatternService service;

    @ApiOperation("添加模式")
    @PostMapping(value = "/create")
    public CommonResult createBreedPattern(@RequestBody BreedPattern breed) {

        int count = service.createBreedPattern(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改模式")
    @PutMapping(value = "/update")
    public CommonResult updateBreedPattern(@RequestBody BreedPattern breed) {

        int count = service.updateBreedPattern(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据养殖id获取模式")
    @GetMapping(value = "/list")
    public CommonResult<List<BreedPattern>> getBreedPatternList(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedPattern> PatternList = service.getBreedPatternList(pageSize, pageNum);
        return CommonResult.success(PatternList);
    }

    @ApiOperation("根据id获取模式信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedPattern> getBreedPatternById(@PathVariable Long id) {
        BreedPattern info = service.getBreedPatternById(id);
        return CommonResult.success(info);
    }

    @ApiOperation("删除模式信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedPattern(@PathVariable Long id) {
        Integer count = service.deletePattern(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
