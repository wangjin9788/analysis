package com.jykj.user.service;

import com.jykj.user.dto.vo.BreedListVo;
import com.jykj.user.entity.Breed;
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
public interface IBreedService extends IService<Breed> {
    int createBreed(Breed breed);

    int updateBreed(Breed breed);

    List<BreedListVo> getBreedList(Integer status, Integer pageSize, Integer pageNum,Integer type);

    Breed getBreedById(long id);

    Integer updateBreedStatusAndSummary(long id);

    Integer deleteBreed(long id);



}
