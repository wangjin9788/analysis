package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class FermentationDataVo {
    //发酵表id
    private long id;
    //发酵编号
    private long number;
    //模式名称
    private String patternName;
    //图片
    private String img;
    //创建时间
    private String createTime;
    //评价
    private String evaluate;
}
