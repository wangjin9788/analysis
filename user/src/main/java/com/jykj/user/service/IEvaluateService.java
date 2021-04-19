package com.jykj.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jykj.user.entity.Evaluate;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
public interface IEvaluateService extends IService<Evaluate> {
    int createEvaluate(Evaluate eval);
}