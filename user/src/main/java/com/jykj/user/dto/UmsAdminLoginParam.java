package com.jykj.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Data
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)

    private String username;
    @ApiModelProperty(value = "密码", required = true)

    private String password;

}
