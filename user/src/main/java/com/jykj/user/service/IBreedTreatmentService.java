package com.jykj.user.service;

import com.jykj.user.dto.vo.BreedTreatmentVo;
import com.jykj.user.entity.BreedTreatment;
import com.jykj.user.entity.BreedTreatment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface IBreedTreatmentService extends IService<BreedTreatment> {
    int createBreedTreatment(BreedTreatment breed);

    int updateBreedTreatment(BreedTreatment breed);

    List<BreedTreatmentVo> getBreedTreatmentList(Long bdId, Integer pageSize, Integer pageNum);

    BreedTreatment getBreedTreatmentById(long id);

    Integer deleteTreatment(long id);
}
