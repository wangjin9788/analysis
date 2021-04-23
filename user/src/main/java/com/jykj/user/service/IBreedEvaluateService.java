package com.jykj.user.service;

import com.jykj.user.entity.BreedDetail;
import com.jykj.user.entity.BreedEvaluate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-23
 */
public interface IBreedEvaluateService extends IService<BreedEvaluate> {
    int createBreedEvaluate(BreedEvaluate breed);

    int updateBreedEvaluate(BreedEvaluate breed);

    List<BreedEvaluate> getBreedEvaluateList(long bid, Integer pageSize, Integer pageNum);

    BreedEvaluate getBreedEvaluateById(long id);

    Integer deleteEvaluate(long id);
}
