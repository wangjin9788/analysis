package com.jykj.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 王进
 * @since 2021-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 天气id
     */
    @TableId(value = "wid", type = IdType.AUTO)
    private Long wid;

    /**
     * 气温
     */
    private Float temperature;

    /**
     * 湿度
     */
    private Float humidity;

    private LocalDateTime createTime;

    /**
     * 类型（0室内  1室外）
     */
    private Integer type;


}
