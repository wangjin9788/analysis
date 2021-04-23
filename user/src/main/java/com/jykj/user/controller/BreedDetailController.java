package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.BreedDetail;
import com.jykj.user.service.IBreedDetailService;
import com.jykj.user.service.IBreedService;
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
@RequestMapping("/breed-detail")
@Api(tags = "BreedDetailController", description = "养殖详情管理")
public class BreedDetailController {

    @Autowired
    private IBreedDetailService service;

    @ApiOperation("添加养殖信息")
    @PostMapping(value = "/create")
    public CommonResult createBreedDetail(@RequestBody BreedDetail breed) {

        int count = service.createBreedDetail(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改养殖信息")
    @PutMapping(value = "/update")
    public CommonResult updateBreedDetail(@RequestBody BreedDetail breed) {

        int count = service.updateBreedDetail(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取养殖信息")
    @GetMapping(value = "/list/{id}")
    public CommonResult<List<BreedDetail>> getBreedDetailList(@PathVariable(value = "id") long bId,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BreedDetail> evaluateList = service.getBreedDetailList(bId,pageSize,pageNum);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("根据id获取评价信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BreedDetail> getBreedDetailById(@PathVariable Long id) {
        BreedDetail info = service.getBreedDetailById(id);
        return CommonResult.success(info);
    }

    @ApiOperation("删除养殖信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedDetail(@PathVariable Long id) {
        Integer count = service.deleteBreedDetail(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
