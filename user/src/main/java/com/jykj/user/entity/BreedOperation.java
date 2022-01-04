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
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BreedOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖操作表id
     */
    @TableId(value = "bo_id", type = IdType.AUTO)
    private Long boId;

    /**
     * 养殖主表id关联
     */
    private Long bid;

    /**
     * 投喂重量
     */
    private Float feeding;

    /**
     * 浇灌量ml
     */
    private Long water;

    /**
     * 浇灌后的湿度
     */
    private Float waterHumidity;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 发酵堆编号
     */
    private String ferNumber;
    /**
     * 操作类型（0：浇水 1：饲喂 2：浇水/饲喂 ）
     */
    private Integer type;

}
