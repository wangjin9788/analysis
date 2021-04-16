package com.jykj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author 王进
 * @since 2021-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台用户数量
     */
    private Integer adminCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;


}
