package com.jykj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王进
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BreedPathology implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 病理ID
     */
    @TableId(value = "bp_id", type = IdType.AUTO)
    private Long bpId;

    /**
     * 病症
     */
    private String disease;
    /**
     * 引起原因
     */
    private String reason;
    /**
     * 解决方案
     */
    private String resolvent;



}
