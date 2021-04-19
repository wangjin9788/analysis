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
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评价字典表
     */
    @TableId(value = "eid", type = IdType.AUTO)
    private Long eid;

    /**
     * 评价
     */
    private String explain;


}
