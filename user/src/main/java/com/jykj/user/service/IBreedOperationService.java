package com.jykj.user.service;

import com.jykj.user.entity.BreedOperation;
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
public interface IBreedOperationService extends IService<BreedOperation> {
    int createBreedOperation(BreedOperation breed);

    int updateBreedOperation(BreedOperation breed);

    List<BreedOperation> getBreedOperationList(long bid, Integer pageSize, Integer pageNum);

    BreedOperation getBreedOperationById(long id);

    Integer deleteOperation(long id);
}
