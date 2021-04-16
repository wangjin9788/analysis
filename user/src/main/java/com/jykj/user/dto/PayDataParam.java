package com.jykj.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PayDataParam {

    /**
     * 支付ID
     */

    private Long epid;

    /**
     * 支付的品类ID
     */
    private Long prcid;

    /**
     * 支付金额
     */
    private Double pay;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人ID
     */
    private Long createId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人ID
     */
    private Long updateId;


    private String typeName;
}
