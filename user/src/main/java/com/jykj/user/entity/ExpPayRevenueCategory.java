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
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExpPayRevenueCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付营收id
     */
    @TableId(value = "prcid", type = IdType.AUTO)
    private Long prcid;

    /**
     * 类型（0：支出 1：收入）
     */
    private Integer type;

    /**
     * 描述
     */
    private String typeName;


}
