package com.festech.webapi.service.impl;

import com.festech.webapi.base.constant.ErrorConstant;
import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.base.utils.Md5Util;
import com.festech.webapi.controller.manage.requestDO.AdminLoginDO;
import com.festech.webapi.domain.ManageAdminInfo;
import com.festech.webapi.repo.IManageAdminInfoRepo;
import com.festech.webapi.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IManageAdminInfoRepo manageAdminInfoRepository;

    @Override
    public ResultDO adminLogin(AdminLoginDO adminLoginDO) throws AppWebException {
        ResultDO resultDO = new ResultDO();

        Map data = new HashMap();

        String account = adminLoginDO.getAccount();
        String password = adminLoginDO.getPassword();

        password = Md5Util.MD5Encode(password, "utf-8");

        ManageAdminInfo manageAdminInfo = manageAdminInfoRepository.selectByAccountAndPassword(account, password);

        if (manageAdminInfo == null) {

            throw new AppWebException(ErrorConstant.OUTOF_SERVER_ERROR.getCode(), "请输入正确的用户名密码");

        }

        data.put("token", manageAdminInfo.getToken());

        resultDO.setData(data);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO queryAdminInfo(String token) throws AppWebException {
        ResultDO resultDO = new ResultDO();
        Map data = new HashMap();

        ManageAdminInfo manageAdminInfo = manageAdminInfoRepository.selectByToken(token);

        if (manageAdminInfo == null) {

            throw new AppWebException(ErrorConstant.OUTOF_SERVER_ERROR.getCode(), "管理员不存在");

        }

        data.put("name", manageAdminInfo.getName());
        data.put("email", manageAdminInfo.getEmail());
        data.put("avatar", manageAdminInfo.getAvatar());
        data.put("roles", "管理员");

        resultDO.setData(data);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
