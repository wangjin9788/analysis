package com.jykj.user.dto.vo;

import lombok.Data;

@Data
public class BreedListVo {
    private long bid;
    //投入时间
    private String inputTime;
    //投入重量
    private float inputWeight;
    //产出时间
    private String proTime;
    //产出重量
    private float proWeight;
    //养殖模式
    private String pattern;
    //材料（发酵）id
    private String feedIds;
    //状态
    private int status;


}
