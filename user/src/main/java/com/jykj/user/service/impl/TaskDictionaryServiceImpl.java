package com.jykj.user.service.impl;

import com.jykj.user.dto.vo.TaskDictionaryVo;
import com.jykj.user.entity.TaskDictionary;
import com.jykj.user.mapper.TaskDictionaryMapper;
import com.jykj.user.service.ITaskDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-11-30
 */
@Service
public class TaskDictionaryServiceImpl extends ServiceImpl<TaskDictionaryMapper, TaskDictionary> implements ITaskDictionaryService {

    @Override
    public TaskDictionaryVo getIntervalList(int type) {
        TaskDictionaryVo vo = baseMapper.getIntervalListById(type);
        if (!StringUtils.isEmpty(vo.getIntervalTime())) {
            List<Integer> arr = new ArrayList<>();
            String[] time = vo.getIntervalTime().split(",");
            for (String a :
                    time) {
                arr.add(Integer.parseInt(a));
            }
            vo.setIntervalList(arr);
        }
        return vo;
    }
}
