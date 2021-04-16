package com.jykj.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PayAnalysisDataParam {
    private String date;
    private float pay;
    private float revenue;
}
