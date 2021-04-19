package com.jykj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jykj.user.entity.FerPattern;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface IFerPatternService extends IService<FerPattern> {
    int createFerPattern(FerPattern pattern);

    int updateFerPattern(FerPattern pattern);

    List<FerPattern> getFerPatternList();

    FerPattern getFerPatternById(Long id);
}
