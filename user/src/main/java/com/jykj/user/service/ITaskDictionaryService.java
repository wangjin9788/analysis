package com.jykj.user.service;

import com.jykj.user.dto.vo.TaskDictionaryVo;
import com.jykj.user.entity.TaskDictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2021-11-30
 */
public interface ITaskDictionaryService extends IService<TaskDictionary> {
   TaskDictionaryVo getIntervalList(int type );
}
