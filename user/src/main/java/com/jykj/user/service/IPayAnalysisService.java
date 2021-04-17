package com.jykj.user.service;

import com.jykj.user.dto.vo.PayCategoryPicAnalysisVo;
import com.jykj.user.dto.vo.PayDetailAnalysisVo;
import com.jykj.user.dto.vo.PayRevenuePieAnalysisVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPayAnalysisService {

    List<PayDetailAnalysisVo> getPayAndRevenueAnalysis();

    List<PayRevenuePieAnalysisVo> getPayPicAnalysis(String time);

    List<PayCategoryPicAnalysisVo> getPayCategoryAnalysis( String time);

}
