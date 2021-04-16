package com.jykj.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.PayDataParam;
import com.jykj.user.dto.RevenueDataParam;
import com.jykj.user.entity.ExpPay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface ExpPayMapper extends BaseMapper<ExpPay> {

    List<PayDataParam> getPayList(Page<PayDataParam> page, @Param("time") String time);
}
