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
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BreedSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖总结表
     */
    @TableId(value = "bm_id", type = IdType.AUTO)
    private Long bmId;

    /**
     * 编号
     */
    private Long number;

    /**
     * 养殖模式
     */
    private String evaluate;

    /**
     * 土样
     */
    private String soil;

    /**
     * 投入重量
     */
    private Float inputWeight;

    /**
     * 投入时间
     */
    private String inputTime;

    /**
     * 产出重量
     */
    private Float produceWeight;

    /**
     * 饲料id
     */
    private String feedIds;

    /**
     * 天气平均温度
     */
    private Float meanTemperature;

    /**
     * 土壤平均温度
     */
    private Float meanSoilTemperature;

    /**
     * 空气平均湿度
     */
    private Float meanHumidity;

    /**
     * 土壤平均湿度
     */
    private Float meanSoilHumidity;

    /**
     * 是否有异常
     */
    private String abnormal;

    /**
     * 异常说明
     */
    private String description;

    /**
     * 产出评价
     */
    private String produceEvaluate;

    /**
     * 孵化评价
     */
    private String hatchEvaluate;

    /**
     * 养殖周期
     */
    private Integer cycle;

    /**
     * 出售价格
     */
    private Float price;

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


}
