package com.festech.webapi.repo.impl;

import com.festech.webapi.domain.ManageAdminInfo;
import com.festech.webapi.mapper.ManageAdminInfoMapper;
import com.festech.webapi.repo.IManageAdminInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

@Repository
public class ManageAdminInfoRepo extends BaseRepo<ManageAdminInfo>
        implements IManageAdminInfoRepo {

    @Autowired
    private ManageAdminInfoMapper manageAdminInfoMapper;

    @Override
    public ManageAdminInfo selectByAccountAndPassword(String account, String password) {
        Example example = new Example(ManageAdminInfo.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account", account);
        criteria.andEqualTo("password", password);

        return manageAdminInfoMapper.selectOneByExample(example);
    }

    @Override
    public ManageAdminInfo selectByToken(String token) {
        Example example = new Example(ManageAdminInfo.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("token", token);

        return manageAdminInfoMapper.selectOneByExample(example);
    }
}
