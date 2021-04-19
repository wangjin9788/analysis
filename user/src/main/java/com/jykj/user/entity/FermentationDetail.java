package com.jykj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 王进
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FermentationDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发酵表详情id
     */
    @TableId(value = "fd_id", type = IdType.AUTO)
    private Long fdId;

    /**
     * 发酵主表id
     */
    private long fid;
    
    /**
     * 检查是当前温度
     */
    private Float temperature;

    /**
     * 发酵堆温度
     */
    private Float heapTemperature;

    /**
     * 当前湿度
     */
    private Integer humidity;

    /**
     * 堆内湿度
     */
    private Integer heapHumidity;

    /**
     * ph值
     */
    private Float ph;

    /**
     * 原料重量
     */
    private Float weight;

    /**
     * 发酵状态（0-正在发酵  1发酵结束）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
