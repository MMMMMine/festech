package com.festech.webapi.controller.manage;

import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.service.IFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@Api(description = "文件控制器", tags = {"file-controller"})
public class FileController {

    @Autowired
    IFileService fileService;

    @PostMapping(value = "/v1/upload_pic")
    @ApiOperation(value = "上传图片")
    public ResultDO uploadPic(
            @ApiParam(name = "file", value = "图片文件", required = true)
            @RequestParam(name = "file") MultipartFile file
    ) throws IOException, AppWebException {

        return fileService.uploadPic(file);
    }

    @PostMapping(value = "/v1/upload_pic2")
    @ApiOperation(value = "上传图片")
    public Map uploadPic2(
            @ApiParam(name = "file", value = "图片文件", required = true)
            @RequestParam(name = "file") MultipartFile file
    ) throws IOException, AppWebException {

        return fileService.uploadPic2(file);
    }

}
