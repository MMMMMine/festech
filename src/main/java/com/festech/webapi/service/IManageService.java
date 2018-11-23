package com.festech.webapi.service;

import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.controller.manage.requestDO.AddOrUpInfosDO;

public interface IManageService {
    ResultDO addOrUpInfos(AddOrUpInfosDO addOrUpInfosDO);

    ResultDO queryInfosById(int id);
}
