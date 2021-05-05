package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.entity.Task;
import com.jykj.user.mapper.TaskMapper;
import com.jykj.user.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

    @Override
    public int createTask(Task task) {
        task.setStatus(0);
        task.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(task);
    }
    @Override
    public int updateTask(Task task) {
        return baseMapper.updateById(task);
    }



    @Override
    public Integer deleteTask(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Task getTaskInfo(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Task> getTaskList(String year, String month, Integer pageSize, Integer pageNum) {
        QueryWrapper<Task> query = new QueryWrapper<>();
        query.orderByDesc("create_time");
        Page<Task> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPage(page,query).getRecords();
    }
    @Override
    public List<Task> getSchedulerTaskList() {
        LocalDate now = LocalDate.now();
        String taskTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Task> list = baseMapper.getSchedulerTaskList(taskTime);

        return list;
    }

}
