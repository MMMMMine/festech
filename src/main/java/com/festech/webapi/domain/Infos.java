package com.festech.webapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "infos")
public class Infos {
    @Id
    private Integer id;

    private String title;

    private String type;

    private String cover;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "is_publish")
    private Integer isPublish;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    private String content;

}