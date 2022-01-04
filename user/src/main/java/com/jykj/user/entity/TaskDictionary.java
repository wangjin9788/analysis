package com.jykj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TaskDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "td_id", type = IdType.AUTO)
    private Long tdId;

    /**
     * 任务内容
     */
    private String taskContent;

    /**
     * 类型（0：其他 1：翻堆 2：浇水）
     */
    private Integer type;

    /**
     * 时间间隔
     */
    private String intervalTime;


}
