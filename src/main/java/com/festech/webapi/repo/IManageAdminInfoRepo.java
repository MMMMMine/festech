package com.festech.webapi.repo;


import com.festech.webapi.domain.ManageAdminInfo;

public interface IManageAdminInfoRepo extends IBaseRepo<ManageAdminInfo> {

    ManageAdminInfo selectByAccountAndPassword(String account, String password);

    ManageAdminInfo selectByToken(String token);
}
