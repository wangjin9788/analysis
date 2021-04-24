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
public class BreedEvaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖评价表
     */
    @TableId(value = "be_id", type = IdType.AUTO)
    private Long beId;

    /**
     * 养殖箱表
     */
    private Long bid;

    /**
     * 产出评价
     */
    private String produceEvaluate;

    /**
     * 孵化评价
     */
    private String hatchEvaluate;

    /**
     * 养殖周期
     */
    private Integer cycle;

    /**
     * 出售价格
     */
    private Float price;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
