package com.jykj.user.service;

import com.jykj.user.dto.vo.TaskRelationVo;
import com.jykj.user.entity.TaskInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
public interface ITaskService extends IService<TaskInfo> {
    int updateTask(TaskInfo TaskInfo);

    int createTask(TaskInfo TaskInfo);

    Integer deleteTask(long id);

    TaskInfo getTaskInfo(long id);

    List<TaskInfo> getTaskList(String year, String month, Integer pageSize, Integer pageNum);

    List<TaskInfo> getSchedulerTaskList();

    //修改任务状态
    Integer updateStatus(long id) throws ParseException;

    TaskInfo handleTaskByType(Long contactId, Integer type, Integer number) throws ParseException;
    List<TaskRelationVo> getTaskRelationList(int type);
    TaskInfo getNewTaskByType(long contactId, int type);
}
