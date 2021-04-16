package com.jykj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jykj.user.dto.PayDataParam;
import com.jykj.user.entity.ExpPay;
import com.jykj.user.entity.ExpPayRevenueCategory;
import com.jykj.user.entity.ExpRevenue;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface IExpPayService extends IService<ExpPay> {
    int create(ExpPay expPay );

    List<PayDataParam> list(String keyword, int pageSize, int pageNum);

    List<ExpPayRevenueCategory> getPayRevenueCategory();

    int update( ExpPay expPay);

    ExpPay getPayDetail( Long id);

    int delete( Long id);
}
