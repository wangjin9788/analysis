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
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务表
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Long tid;

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


}
