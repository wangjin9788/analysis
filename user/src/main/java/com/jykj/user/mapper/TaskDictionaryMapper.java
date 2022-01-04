package com.jykj.user.mapper;

import com.jykj.user.dto.vo.TaskDictionaryVo;
import com.jykj.user.entity.TaskDictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-11-30
 */
public interface TaskDictionaryMapper extends BaseMapper<TaskDictionary> {
    TaskDictionaryVo getIntervalListById(@Param(value = "type") int type);
}
