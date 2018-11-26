package com.festech.webapi.repo;

import com.festech.webapi.base.result.MyPageInfo;
import com.festech.webapi.domain.Infos;

public interface IInfosRepo extends IBaseRepo<Infos> {

    Infos selectInfosByTitle(String title);

    MyPageInfo selectInfosListByType(int type, int pageNum, int pageSize);

    Infos selectInfosById(int id);
}
