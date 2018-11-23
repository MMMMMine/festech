package com.festech.webapi.service;


import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.controller.manage.requestDO.AdminLoginDO;

public interface IAdminService {

    ResultDO adminLogin(AdminLoginDO adminLoginDO) throws AppWebException;

    ResultDO queryAdminInfo(String token) throws AppWebException;
}
