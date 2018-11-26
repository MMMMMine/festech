package com.festech.webapi.controller.manage;

import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.controller.manage.requestDO.AddOrUpInfosDO;
import com.festech.webapi.service.IManageService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class ManageController {

    @Autowired
    private IManageService manageService;

    @PostMapping(value = "/v1/addOrUpInfos", consumes = "application/json")
    public ResultDO addOrUpInfos(
            @RequestBody @ApiParam(name = "新增或更新镀锌管规格对象", value = "传入json格式", required = true)
            @Valid AddOrUpInfosDO addOrUpInfosDO
    ) throws AppWebException {

        return manageService.addOrUpInfos(addOrUpInfosDO);
    }

    @GetMapping(value = "/v1/queryInfosById")
    public ResultDO queryInfosById(
            @RequestParam int id
    ) throws AppWebException {

        return manageService.queryInfosById(id);
    }

    @GetMapping(value = "/v1/queryInfosListByType")
    public ResultDO queryInfosListByType(
            @RequestParam int type,
            @RequestParam int pageNum,
            @RequestParam int pageSize
    ) throws AppWebException {

        return manageService.queryInfosListByType(type,pageNum,pageSize);
    }
}
