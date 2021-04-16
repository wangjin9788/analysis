package com.jykj.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RevenueDataParam  {


    /**
     * 营收ID
     */
    private Long rid;

    /**
     * 营收id
     */
    private Integer prcid;

    /**
     * 金额
     */
    private Double money;

    private Long createId;

    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    private String typeName;

}
