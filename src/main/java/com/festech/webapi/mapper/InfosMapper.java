package com.festech.webapi.mapper;

import com.festech.webapi.base.utils.MyMapper;
import com.festech.webapi.domain.Infos;

import java.util.List;
import java.util.Map;

public interface InfosMapper extends MyMapper<Infos> {
    List<Map> selectLatestNews();
}