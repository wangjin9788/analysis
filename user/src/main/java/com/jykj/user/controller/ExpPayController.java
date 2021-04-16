package com.jykj.user.controller;


import com.jykj.user.common.api.CommonResult;
import com.jykj.user.dto.PayDataParam;
import com.jykj.user.dto.RevenueDataParam;
import com.jykj.user.entity.ExpPay;
import com.jykj.user.entity.ExpPayRevenueCategory;
import com.jykj.user.entity.ExpRevenue;
import com.jykj.user.service.IExpPayService;
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
 * @since 2021-04-10
 */
@RestController
@Api(tags = "ExpPayController", description = "支付管理")
@RequestMapping("/exp-pay")
public class ExpPayController {
@Autowired
    private IExpPayService payService;
    @ApiOperation("添加支出")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody ExpPay expPay) {
        int count = payService.create(expPay);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("支出列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PayDataParam>> list(@RequestParam(value = "selectDay", required = false) String keyword,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PayDataParam> adminList = payService.list(keyword, pageSize, pageNum);
        return CommonResult.success(adminList);
    }
    @ApiOperation("获取品类详情")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public CommonResult<List<ExpPayRevenueCategory>>  getCategory(){
        return CommonResult.success(payService.getPayRevenueCategory());
    }
    @ApiOperation("修改支出")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update( @RequestBody ExpPay expPay) {
        int count = payService.update(expPay);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("根据ID获取支出详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ExpPay> getRevenueById(@PathVariable Long id) {
        ExpPay detail = payService.getPayDetail(id);
        return CommonResult.success(detail);
    }
    @ApiOperation("删除指定支出信息")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int count = payService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
