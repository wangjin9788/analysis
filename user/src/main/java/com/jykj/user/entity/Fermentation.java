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
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Fermentation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发酵表id

     */
    @TableId(value = "fid", type = IdType.AUTO)
    private Long fid;

    /**
     * 发酵堆编号
     */
    private Long number;

    /**
     * 发酵种类表id
     */
    private Long fpId;

    /**
     * 图片url
     */
    private String img;

    /**
     * 评价id
     */
    private Long eid;

    /**
     * 发酵时间
     */
    private LocalDateTime createTime;


}
