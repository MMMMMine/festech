package com.festech.webapi.repo;

import com.festech.webapi.base.result.MyPageInfo;
import com.festech.webapi.domain.Infos;

public interface IInfosRepo extends IBaseRepo<Infos> {

    Infos selectInfosByTitle(String title);

    MyPageInfo selectInfosListByType(String type, int pageNum, int pageSize);
}
