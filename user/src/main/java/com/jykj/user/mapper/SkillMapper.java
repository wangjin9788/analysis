package com.jykj.user.mapper;

import com.jykj.user.entity.Skill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-12-02
 */
public interface SkillMapper extends BaseMapper<Skill> {
    Skill getSkillContentByType(@Param("type") int type);
}
