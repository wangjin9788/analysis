package com.jykj.user.service;

import com.jykj.user.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
public interface ITaskService extends IService<Task> {
    int updateTask(Task task);

    int createTask(Task task);

    Integer deleteTask(long id);

    Task getTaskInfo(long id);

    List<Task> getTaskList(String year, String month, Integer pageSize, Integer pageNum);

    List<Task> getSchedulerTaskList();
}
