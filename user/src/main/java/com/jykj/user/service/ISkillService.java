package com.jykj.user.service;

import com.jykj.user.entity.Skill;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-12-02
 */
public interface ISkillService extends IService<Skill> {

    Skill getSkillContentByType(int type);
}
