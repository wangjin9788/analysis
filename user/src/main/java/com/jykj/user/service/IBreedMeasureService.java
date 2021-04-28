package com.jykj.user.service;

import com.jykj.user.dto.vo.MeasureAnalysisVo;
import com.jykj.user.entity.BreedMeasure;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface IBreedMeasureService extends IService<BreedMeasure> {
    int createBreedMeasure(BreedMeasure breed);

    int updateBreedMeasure(BreedMeasure breed);

    List<BreedMeasure> getBreedMeasureList(long bid, Integer pageSize, Integer pageNum);

    BreedMeasure getBreedMeasureById(long id);

    Integer deleteMeasure(long id);

    List<MeasureAnalysisVo> getMeasureAnalysis(Long id);
}
