package com.festech.webapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "manage_admin_info")
public class ManageAdminInfo {
    @Id
    @Column(name = "admin_id")
    private Long adminId;

    private String account;

    private String password;

    private String token;

    private String name;

    private String email;

    private String avatar;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

}