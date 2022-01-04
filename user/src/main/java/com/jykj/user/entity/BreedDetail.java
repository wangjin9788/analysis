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
public class BreedDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖详情表id
     */
    @TableId(value = "bd_id", type = IdType.AUTO)
    private Long bdId;

    /**
     * 养殖主表
     */
    private Long bid;
    /**
     * 气温主表
     */
    private Long wid;
    /**
     * 土壤温度
     */
    private Float soilTemperature;

    /**
     * 土壤湿度
     */
    private Float soilHumidity;

    /**
     * 异常情况（0：无异常 1：有异常）
     */
    private Integer abnormal;

    /**
     * 异常说明
     */
    private String description;

    /**
     * 异常图片
     */
    private String imgUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * ph值
     */
    private float ph;


}
