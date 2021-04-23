package com.jykj.user.service;

import com.jykj.user.entity.BreedPattern;
import com.jykj.user.entity.BreedPattern;
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
public interface IBreedPatternService extends IService<BreedPattern> {
    int createBreedPattern(BreedPattern breed);

    int updateBreedPattern(BreedPattern breed);

    List<BreedPattern> getBreedPatternList( Integer pageSize, Integer pageNum);

    BreedPattern getBreedPatternById(long id);

    Integer deletePattern(long id);
}
