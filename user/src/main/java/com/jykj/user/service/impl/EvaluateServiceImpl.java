package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jykj.user.entity.Evaluate;
import com.jykj.user.mapper.EvaluateMapper;
import com.jykj.user.service.IEvaluateService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements IEvaluateService {

    @Override
    public int createEvaluate(Evaluate eval) {
        return baseMapper.insert(eval);
    }
}
