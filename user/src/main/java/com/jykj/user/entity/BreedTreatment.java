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
public class BreedTreatment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 治疗表
     */
    @TableId(value = "bt_id", type = IdType.AUTO)
    private Long btId;

    /**
     * 关联详情表
     */
    private Long bdId;

    /**
     * 治疗类型（0:伴食，1：喷洒）
     */
    private Integer type;

    /**
     * 采用药物
     */
    private String medicine;

    /**
     * 病理名称
     */
    private String illnessName;

    /**
     * 病理说明(出现原因)
     */
    private String illnessExplain;

    /**
     * 治疗效果评价id
     */
    private Integer eid;

    /**
     * 病理图片
     */
    private String imgUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
