package com.festech.webapi.service;

import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface IFileService {

    ResultDO uploadPic(MultipartFile file) throws AppWebException, IOException;

    Map uploadPic2(MultipartFile file) throws AppWebException, IOException;
}
