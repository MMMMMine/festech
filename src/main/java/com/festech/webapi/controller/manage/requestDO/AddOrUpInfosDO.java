package com.festech.webapi.controller.manage.requestDO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "新增或更新轮播图对象")
@Getter
public class AddOrUpInfosDO {

    @ApiModelProperty(value = "id", name = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "封面", name = "cover", example = "www.grownest.cn/logo/jzlogo.png")
    private String cover;

    @ApiModelProperty(value = "内容", name = "content", example = "1")
    private String content;

    @ApiModelProperty(value = "是否上架", name = "isPublish", example = "5")
    private Integer isPublish;

    @ApiModelProperty(value = "是否有效", name = "isActive", example = "5")
    private Integer isActive;

}
