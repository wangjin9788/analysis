package com.jykj.user.mapper;

import com.jykj.user.entity.TaskInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
public interface TaskMapper extends BaseMapper<TaskInfo> {
    List<TaskInfo> getSchedulerTaskList(@Param(value = "time") String time);

    TaskInfo getNewTaskByType(@Param("contactId")Long contactId ,@Param("type")Integer type);
}
