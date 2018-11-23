package com.festech.webapi.repo.impl;

import com.festech.webapi.domain.UploadFileInfo;
import com.festech.webapi.mapper.UploadFileInfoMapper;
import com.festech.webapi.repo.IUploadFileInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

@Repository
public class UploadFileInfoRepo extends BaseRepo<UploadFileInfo>
        implements IUploadFileInfoRepo {

    @Autowired
    private UploadFileInfoMapper uploadFileInfoMapper;


    @Override
    public UploadFileInfo selectFileByMD5(String md5) {

        Example example = new Example(UploadFileInfo.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("md5", md5);

        return uploadFileInfoMapper.selectOneByExample(example);

    }
}
