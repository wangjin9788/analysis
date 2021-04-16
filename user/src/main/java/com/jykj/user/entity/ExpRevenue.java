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
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExpRevenue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 营收ID
     */
    @TableId(value = "rid", type = IdType.AUTO)
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

}
