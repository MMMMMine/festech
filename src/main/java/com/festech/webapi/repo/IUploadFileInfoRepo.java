package com.festech.webapi.repo;


import com.festech.webapi.domain.UploadFileInfo;

public interface IUploadFileInfoRepo extends IBaseRepo<UploadFileInfo>{

    UploadFileInfo selectFileByMD5(String md5);
}
