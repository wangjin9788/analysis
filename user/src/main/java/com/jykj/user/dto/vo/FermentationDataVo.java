package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class FermentationDataVo {
    //发酵表id
    private long fid;
    //模式名称
    private String patternName;
    //图片
    private String img;
    //创建时间
    private String createTime;
    //评价
    private String evaluate;
    /**
     * 发酵状态（0-正在发酵  1发酵结束）
     */
    private Integer status;
    //创建时间
    private String ferTime;
    //原料重量
    private float weight;
    /**
     * 单前是第几次发酵
     */
    private Integer curFermentation;
    /**
     * 发酵堆编号
     */
    private Integer number;
}
