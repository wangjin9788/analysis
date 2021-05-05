package com.jykj.user.mapper;

import com.jykj.user.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
public interface TaskMapper extends BaseMapper<Task> {
    List<Task> getSchedulerTaskList(@Param(value = "time") String time);
}
