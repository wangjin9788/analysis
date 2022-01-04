package com.jykj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 王进
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TaskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务表
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Long tid;
    /**
     *关联事物的id
     */
    private Long contactId;
    /**
     * 任务内容
     */
    private String taskContent;

    private String taskTime;

    /**
     * 状态（0：未读取 1：读取）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 类型（0：其他 1：发酵翻堆 2：淋水）
     */
    private Integer type;
    /**
     *时间下标
     */
    private Integer timeIndex;
    /**
     * 关联编号
     */
    private Integer number;
}
