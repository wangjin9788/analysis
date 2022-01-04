package com.jykj.user.service.impl;

import com.jykj.user.entity.Skill;
import com.jykj.user.mapper.SkillMapper;
import com.jykj.user.service.ISkillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-12-02
 */
@Service
public class SkillServiceImpl extends ServiceImpl<SkillMapper, Skill> implements ISkillService {

    @Override
    public Skill getSkillContentByType(int type) {
       return baseMapper.getSkillContentByType(type);
    }
}
