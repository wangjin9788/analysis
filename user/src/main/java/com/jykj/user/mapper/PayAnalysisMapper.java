package com.jykj.user.mapper;

import com.jykj.user.dto.vo.PayCategoryPicAnalysisVo;
import com.jykj.user.dto.vo.PayDetailAnalysisVo;
import com.jykj.user.dto.vo.PayRevenuePieAnalysisVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayAnalysisMapper {

    List<PayDetailAnalysisVo> getPayAndRevenueAnalysis();

    List<PayRevenuePieAnalysisVo> getPayPicAnalysis(@Param("time") String time);

    List<PayCategoryPicAnalysisVo> getPayCategoryAnalysis(@Param("time") String time);

    List<Integer> getYearData();

    List<Integer> getMonth();
}
