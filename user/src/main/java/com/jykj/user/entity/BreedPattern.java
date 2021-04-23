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
public class BreedPattern implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖模式表id
     */
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    /**
     * 说明(箱式)
     */
    private String evaluate;

    /**
     * 增氧
     */
    private Integer aeration;

    /**
     * 土样
     */
    private String soil;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
