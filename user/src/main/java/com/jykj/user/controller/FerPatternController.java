package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.entity.FerPattern;
import com.jykj.user.service.IFerPatternService;
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
@RequestMapping("/fer-pattern")
@Api(tags = "FerPatternController", description = "发酵模式管理")
public class FerPatternController {

    @Autowired
    private IFerPatternService patternService;

    @ApiOperation("添加发酵模式")
    @PostMapping(value = "/create")
    public CommonResult createFerPattern(@RequestBody FerPattern pattern) {

        int count = patternService.createFerPattern(pattern);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改发酵模式")
    @PutMapping(value = "/update")
    public CommonResult updateFerPattern(@RequestBody FerPattern pattern) {

        int count = patternService.updateFerPattern(pattern);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取发酵模式列表")
    @GetMapping(value = "/list")
    public CommonResult<List<FerPattern>> getFerPatternList() {

        List<FerPattern> patternList = patternService.getFerPatternList();
        return CommonResult.success(patternList);
    }

    @ApiOperation("根据id获取发酵模式")
    @GetMapping(value = "/info/{id}")
    public CommonResult<FerPattern> getFerPatternById(@PathVariable Long id) {
        FerPattern patternInfo = patternService.getFerPatternById(id);
        return CommonResult.success(patternInfo);
    }

}
