package com.jykj.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.dto.RevenueDataParam;
import com.jykj.user.entity.ExpPayRevenueCategory;
import com.jykj.user.entity.ExpRevenue;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface IExpRevenueService extends IService<ExpRevenue> {

    int create( ExpRevenue expRevenue);

    List<RevenueDataParam> list(String keyword, int pageSize, int pageNum);

    List<ExpPayRevenueCategory> getCategory();

   int update( ExpRevenue  exp);

    ExpRevenue getRevenue( Long id);

    int delete( Long id);

}
