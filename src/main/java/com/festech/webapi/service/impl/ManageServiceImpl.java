package com.festech.webapi.service.impl;

import com.festech.webapi.base.result.MyPageInfo;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.controller.manage.requestDO.AddOrUpInfosDO;
import com.festech.webapi.domain.Infos;
import com.festech.webapi.repo.IInfosRepo;
import com.festech.webapi.service.IManageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
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

        BeanUtils.copyProperties(addOrUpInfosDO, infos);

        if (addOrUpInfosDO.getId() == null) {
            infos.setIsActive(1).setCreateAt(new Date());
        }

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

    @Override
    public ResultDO queryInfosListByType(int type, int pageNum, int pageSize) {
        ResultDO resultDO = new ResultDO();

        MyPageInfo myPageInfo = infosRepo.selectInfosListByType(type, pageNum, pageSize, 2);

        resultDO.setData(myPageInfo);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
