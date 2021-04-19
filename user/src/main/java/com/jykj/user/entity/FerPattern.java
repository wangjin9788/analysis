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
public class FerPattern implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发酵原材料id
     */
    @TableId(value = "fp_id", type = IdType.AUTO)
    private Integer fpId;

    /**
     * 原材料（鸡粪+树叶）
     */
    private String material;


}
