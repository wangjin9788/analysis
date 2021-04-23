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
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BreedMeasure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖计量表id
     */
    @TableId(value = "bm_id", type = IdType.AUTO)
    private Long bmId;

    /**
     * 养殖主表id
     */
    private Long bid;

    /**
     * 多少条1斤
     */
    private Long count;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 检查时间
     */
    private LocalDateTime checkTime;


}
