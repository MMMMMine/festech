package com.festech.webapi.repo;

import com.festech.webapi.base.result.MyPageInfo;
import com.festech.webapi.domain.Infos;

import java.util.List;
import java.util.Map;

public interface IInfosRepo extends IBaseRepo<Infos> {

    Infos selectInfosByTitle(String title);

    MyPageInfo selectInfosListByType(int type, int pageNum, int pageSize, int isPublish);

    Infos selectInfosById(int id);

    List<Map> selectLatestNews();
}
