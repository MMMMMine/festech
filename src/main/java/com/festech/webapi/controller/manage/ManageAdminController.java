package com.festech.webapi.controller.manage;

import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.controller.manage.requestDO.AdminLoginDO;
import com.festech.webapi.service.IAdminService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class ManageAdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping(value = "/v1/adminLogin", consumes = "application/json")
    public ResultDO adminLogin(
            @RequestBody @ApiParam(name = "管理员登录对象", value = "传入json格式", required = true)
            @Valid AdminLoginDO adminLoginDO
    ) throws AppWebException {

        return adminService.adminLogin(adminLoginDO);
    }

    @GetMapping(value = "/v1/queryAdminInfo")
    public ResultDO queryAdminInfo(
            @RequestParam String token
    ) throws AppWebException {

        return adminService.queryAdminInfo(token);
    }

}
