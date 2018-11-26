package com.festech.webapi.repo.impl;

import com.festech.webapi.base.result.MyPageInfo;
import com.festech.webapi.domain.Infos;
import com.festech.webapi.mapper.InfosMapper;
import com.festech.webapi.repo.IInfosRepo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class InfosRepo extends BaseRepo<Infos>
        implements IInfosRepo {

    @Autowired
    private InfosMapper infosMapper;

    @Override
//    @Cacheable(cacheNames = "selectInfosByTitle", key = "#p0")
    public Infos selectInfosByTitle(String title) {
        Example example = new Example(Infos.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("title", title);
        criteria.andEqualTo("isActive", 1);
        criteria.andEqualTo("isPublish", 1);

        return infosMapper.selectOneByExample(example);
    }

    @Override
    public MyPageInfo selectInfosListByType(int type, int pageNum, int pageSize, int isPublish) {
        Example example = new Example(Infos.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("type", type);
        criteria.andEqualTo("isActive", 1);
        if (isPublish != 2) {
            criteria.andEqualTo("isPublish", isPublish);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Infos> list = infosMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);

        MyPageInfo myPageInfo = new MyPageInfo();
        BeanUtils.copyProperties(pageInfo, myPageInfo);

        return myPageInfo;

    }

    @Override
//    @Cacheable(cacheNames = "selectInfosById", key = "#p0")
    public Infos selectInfosById(int id) {
        return infosMapper.selectByPrimaryKey(id);
    }
}
