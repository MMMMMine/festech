package com.festech.webapi.controller.manage.requestDO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AdminLoginDO {

    private String account;

    private String password;

}
