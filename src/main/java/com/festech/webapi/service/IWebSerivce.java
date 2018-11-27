package com.festech.webapi.service;

import com.festech.webapi.base.result.ResultDO;

public interface IWebSerivce {
    ResultDO searchInfos(String title);

    ResultDO searchInfosList(int type, int pageNum, int pageSize);

    ResultDO queryLatestNews();
}
