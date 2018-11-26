package com.festech.webapi.service.impl;

import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.controller.manage.requestDO.AddOrUpInfosDO;
import com.festech.webapi.domain.Infos;
import com.festech.webapi.repo.IInfosRepo;
import com.festech.webapi.service.IManageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("manageService")
public class ManageServiceImpl implements IManageService {

    @Autowired
    private IInfosRepo infosRepo;

    @Override
    public ResultDO addOrUpInfos(AddOrUpInfosDO addOrUpInfosDO) {
        ResultDO resultDO = new ResultDO();


        Infos infos = new Infos();
        if (infos.getId() == null) {
            infos.setIsActive(1).setCreateAt(new Date());
        }

        BeanUtils.copyProperties(addOrUpInfosDO, infos);

        infosRepo.insertOrUpdate(infos);

        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO queryInfosById(int id) {
        ResultDO resultDO = new ResultDO();

        Infos infos = infosRepo.selectInfosById(id);

        resultDO.setData(infos);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
