package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.RevenueDataParam;
import com.jykj.user.entity.ExpPayRevenueCategory;
import com.jykj.user.entity.ExpRevenue;
import com.jykj.user.service.IExpRevenueService;
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
 * @since 2021-04-10
 */
@RestController
@Api(tags = "ExpPayController", description = "营收管理")
@RequestMapping("/exp-revenue")
public class ExpRevenueController {

    @Autowired
    private IExpRevenueService revenueService;

    @ApiOperation("添加营收")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ExpRevenue expRevenue) {
        int count = revenueService.create(expRevenue);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("营收列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<RevenueDataParam>> list(@RequestParam(value = "selectDay", required = false) String keyword,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<RevenueDataParam> adminList = revenueService.list(keyword, pageSize, pageNum);
        return CommonResult.success(adminList);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public CommonResult<List<ExpPayRevenueCategory>> getCategory() {
        return CommonResult.success(revenueService.getCategory());
    }

    @ApiOperation("修改营收")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody ExpRevenue expRevenue) {
        int count = revenueService.update(expRevenue);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("根据ID获取营收详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ExpRevenue> getRevenueById(@PathVariable Long id) {
        ExpRevenue expRevenue = revenueService.getRevenue(id);
        return CommonResult.success(expRevenue);
    }

    @ApiOperation("删除指定营收信息")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int count = revenueService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
