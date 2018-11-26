package com.festech.webapi.controller.manage.requestDO;

import lombok.Getter;


@Getter
public class AddOrUpInfosDO {

    private Integer id;

    private String title;

    private String cover;

    private String content;

    private Integer type;

    private Integer isPublish;

    private Integer isActive;

}
