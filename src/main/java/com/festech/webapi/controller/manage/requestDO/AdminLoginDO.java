package com.festech.webapi.controller.manage.requestDO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "管理员登录对象")
@Getter
public class AdminLoginDO {

    @ApiModelProperty(value = "账户名", name = "account", example = "admin")
    @NotEmpty(message = "参数异常")
    private String account;

    @ApiModelProperty(value = "密码", name = "password", example = "b31dad715cac2f8d1821ee72b2561da6")
    @NotEmpty(message = "参数异常")
    private String password;

}
