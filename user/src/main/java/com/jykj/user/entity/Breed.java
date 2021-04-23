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
public class Breed implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖表id
     */
    @TableId(value = "bid", type = IdType.AUTO)
    private Long bid;

    /**
     * 投入重量
     */
    private Float inputWeight;

    /**
     * 养殖模式
     */
    private Long pid;

    /**
     * 产出重量
     */
    private Float produceWeight;

    /**
     * 投入时间
     */
    private LocalDateTime inputTime;

    /**
     * 产出时间
     */
    private LocalDateTime produceTime;

    /**
     * 状态（0-未产出  1-产出）
     */
    private Integer status;

    /**
     * 发酵饲料id
     */
    private String feedIds;

}
