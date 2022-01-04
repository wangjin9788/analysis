package com.jykj.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jykj.user.common.utils.DateTimeUtil;
import com.jykj.user.dto.vo.TaskDictionaryVo;
import com.jykj.user.dto.vo.TaskRelationVo;
import com.jykj.user.entity.Breed;
import com.jykj.user.entity.Fermentation;
import com.jykj.user.entity.TaskInfo;
import com.jykj.user.mapper.BreedMapper;
import com.jykj.user.mapper.FermentationMapper;
import com.jykj.user.mapper.TaskMapper;
import com.jykj.user.service.ITaskDictionaryService;
import com.jykj.user.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, TaskInfo> implements ITaskService {

    @Autowired
    private FermentationMapper ferMapper;

    @Autowired
    private BreedMapper breedMapper;

    @Autowired
    private ITaskDictionaryService dictionaryService;

    @Override
    public int createTask(TaskInfo task) {
        task.setStatus(0);
        task.setCreateTime(LocalDateTime.now());
        if (task.getType() > 0) {
            Fermentation fer = ferMapper.selectById(task.getContactId());
            TaskDictionaryVo taskDictionary = dictionaryService.getIntervalList(task.getType());
            task.setTaskContent(taskDictionary.getTaskContent());
            task.setNumber(fer.getNumber());
            task.setTimeIndex(0);
        }
        return baseMapper.insert(task);
    }

    @Override
    public int updateTask(TaskInfo task) {
        return baseMapper.updateById(task);
    }


    @Override
    public Integer deleteTask(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public TaskInfo getTaskInfo(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<TaskInfo> getTaskList(String year, String month, Integer pageSize, Integer pageNum) {
        QueryWrapper<TaskInfo> query = new QueryWrapper<>();
        query.orderByDesc("create_time");
        Page<TaskInfo> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPage(page, query).getRecords();
    }

    @Override
    public List<TaskInfo> getSchedulerTaskList() {
        LocalDate now = LocalDate.now();
        String taskTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<TaskInfo> list = baseMapper.getSchedulerTaskList(taskTime);

        return list;
    }

    @Override
    public Integer updateStatus(long id) throws ParseException {
        //获取该id的数据
        TaskInfo info = baseMapper.selectById(id);
        if (!StringUtils.isEmpty(info) && info.getType() > 0) {
            //处理新增
            handleTaskByType(info.getContactId(), info.getType(), info.getNumber());
        }
        info.setStatus(1);
        return baseMapper.updateById(info);
    }

    /**
     * @param contactId 关联事物的id
     * @param type
     * @param number
     * @return
     */
    @Override
    public TaskInfo handleTaskByType(Long contactId, Integer type, Integer number) throws ParseException {
        //获取该关联id最新的数据是否已经建立任务
        TaskInfo taskInfo = baseMapper.getNewTaskByType(contactId, type);
        //如果是其他类型直接对应类型直接从定时表中获取数据
        TaskDictionaryVo taskDictionary = dictionaryService.getIntervalList(type);
        if (StringUtils.isEmpty(taskDictionary)) {
            return null;
        }
        //校验当前类型的操作是否已经建立过任务
        if (!StringUtils.isEmpty(taskInfo)) {
            Integer index = taskInfo.getTimeIndex();
            int newIndex = Integer.min(taskDictionary.getIntervalList().size() - 1, ++index);
            //发酵类型
            if (type == 1 || type == 6) {
                Fermentation fer = ferMapper.selectById(contactId);
                //获取是否该发酵堆是否已完成或已删除
                if (StringUtils.isEmpty(fer) || fer.getStatus() > 0) {
                    return null;
                }

            } else {
                //获取是否该养殖床是否已完成或已删除
                Breed breed = breedMapper.selectById(contactId);
                if (StringUtils.isEmpty(breed) || breed.getStatus() > 0) {
                    return null;
                }
            }
            Date date = DateTimeUtil.parseDate(taskInfo.getTaskTime(), DateTimeUtil.SFM_DATE);
            Date newDate = DateTimeUtil.chooseDay(date, taskDictionary.getIntervalList().get(newIndex));
            taskInfo.setTimeIndex(newIndex);
            taskInfo.setTaskTime(DateTimeUtil.formatDate(newDate, DateTimeUtil.SFM_DATE));
            taskInfo.setStatus(0);
            taskInfo.setCreateTime(LocalDateTime.now());
            baseMapper.insert(taskInfo);
        } else {
            //如果该关联id没有过任务进行操作类型是发酵需要做别的处理
                TaskInfo info = new TaskInfo();
                info.setContactId(contactId);
                info.setNumber(number);
                info.setTaskContent(taskDictionary.getTaskContent());
                info.setType(type);
                Date date = DateTimeUtil.chooseDay(new Date(), taskDictionary.getIntervalList().get(0));
                info.setTaskTime(DateTimeUtil.formatDate(date, DateTimeUtil.SFM_DATE));
                info.setStatus(0);
                info.setCreateTime(LocalDateTime.now());
                info.setTimeIndex(0);
                baseMapper.insert(info);

        }
        return taskInfo;
    }

    @Override
    public List<TaskRelationVo> getTaskRelationList(int type){
        List<TaskRelationVo> list= new ArrayList<>();
        if(type==1||type==6){
            list=ferMapper.getFerTaskNumberByType(type);
        }else{
           list= breedMapper.getBreedTaskNumberByType(type);
        }
        return list;
    }

    @Override
    public TaskInfo getNewTaskByType(long contactId, int type) {
        return baseMapper.getNewTaskByType(contactId,type);
    }

}
