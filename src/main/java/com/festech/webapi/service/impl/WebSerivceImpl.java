package com.festech.webapi.service.impl;

import com.festech.webapi.base.result.MyPageInfo;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.domain.Infos;
import com.festech.webapi.repo.IInfosRepo;
import com.festech.webapi.service.IWebSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("webService")
public class WebSerivceImpl implements IWebSerivce {

    @Autowired
    private IInfosRepo infosRepo;

    @Override
    public ResultDO searchInfos(String title) {
        ResultDO resultDO = new ResultDO();

        Infos infos = infosRepo.selectInfosByTitle(title);

        resultDO.setData(infos);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO searchInfosList(int type, int pageNum, int pageSize) {
        ResultDO resultDO = new ResultDO();

        MyPageInfo myPageInfo = infosRepo.selectInfosListByType(type,pageNum,pageSize,1);

        resultDO.setData(myPageInfo);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO queryLatestNews() {
        ResultDO resultDO = new ResultDO();

        List<Map> latestNews = infosRepo.selectLatestNews();
        resultDO.setData(latestNews);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
