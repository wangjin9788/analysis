package com.jykj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jykj.user.dto.CompostingTaskParam;
import com.jykj.user.dto.vo.FermentationDataVo;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.entity.FermentationDetail;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface IFermentationService extends IService<Fermentation> {
    int createFermentation(Fermentation fermentation) throws ParseException;

    int updateFermentation(Fermentation fermentation);

    List<FermentationDataVo> getFermentationList(String year, String month, Integer pageSize, Integer pageNum);

    Fermentation getFermentationById(long id);

    int deleteFermentation(long id);

    int updateFermentationAndSummary(long id);

    CompostingTaskParam getCompostingTemperature(long id);
    List<Long> getFerAllId();
}
