package com.festech.webapi.service.impl;

import com.festech.webapi.base.constant.CommonRegExp;
import com.festech.webapi.base.constant.ErrorConstant;
import com.festech.webapi.base.exception.AppWebException;
import com.festech.webapi.base.result.ResultDO;
import com.festech.webapi.base.utils.Md5Util;
import com.festech.webapi.base.utils.UuidUtil;
import com.festech.webapi.domain.UploadFileInfo;
import com.festech.webapi.repo.IUploadFileInfoRepo;
import com.festech.webapi.service.IFileService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.GenericValidator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Service("fileService")
public class FileServiceImpl implements IFileService {

    @Autowired
    IUploadFileInfoRepo uploadFileInfoRepository;

    @Value("${project.upload.path}")
    private String uploadPath;

    @Value("${project.base.url}")
    private String baseUrl;

    @Override
    public ResultDO uploadPic(MultipartFile file) throws AppWebException, IOException {
        ResultDO resultDO = new ResultDO();

        String relativePath = uploadFile(file);

        resultDO.setData(baseUrl + relativePath);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public Map uploadPic2(MultipartFile file) throws AppWebException, IOException {

        Map map = new HashMap();

        List<String> list = new ArrayList<>();

        String relativePath = uploadFile(file);

        list.add(baseUrl + relativePath);

        map.put("errno", 0);
        map.put("data", list);

        return map;
    }


    private String uploadFile(MultipartFile pic) throws AppWebException, IOException {

        String fileName = pic.getOriginalFilename().toLowerCase();

        boolean isLegalPic = GenericValidator.matchRegexp(fileName, CommonRegExp.REGEX_PICTURE_SUFFIX);

        if (!isLegalPic) {

            throw new AppWebException(ErrorConstant.ERROR_VALIDATE_PARAMETER.getCode(), "请传正确的图片格式");

        }

        byte[] bytes = pic.getBytes();

        long fileSize = pic.getSize();

        //获取md5
        String md5 = Md5Util.MD5Encode(bytes);

        if (md5 == null) {

            throw new AppWebException(ErrorConstant.INTERNAL_SERVER_ERROR.getCode(), "MD5加密异常");

        }

        UploadFileInfo uploadFileInfo = uploadFileInfoRepository.selectFileByMD5(md5);

        String relativePath;

        if (uploadFileInfo == null) {

            relativePath = saveFile(fileName, fileSize, bytes, md5);

        } else {

            relativePath = uploadFileInfo.getRelativePath();

        }

        return relativePath;
    }

    private String saveFile(String fileName, long fileSize, byte[] bytes, String md5) throws IOException {

        DateTime dateTime = new DateTime(new Date());

        String yyymmdd = dateTime.toString("yyyyMMdd");

        String relativePath = "/" + yyymmdd;

        String folderPath = uploadPath + relativePath;

        File folder = new File(folderPath);

        if (folder.exists()) {
            // 文件夹已存在

        } else {

            //创建文件夹
            folder.mkdir();

        }

        //文件最终名
        String finalName = md5 + "." + fileName.substring(fileName.lastIndexOf(".") + 1);

        //文件最终路径
        relativePath += "/" + finalName;

        String absolutePath = uploadPath + relativePath;

        File targetFile = new File(absolutePath);

        FileUtils.writeByteArrayToFile(targetFile, bytes);

        //保存上传记录
        UploadFileInfo uploadFileInfo = new UploadFileInfo()
                .setId(UuidUtil.getUuid())
                .setRelativePath(relativePath)
                .setFileName(fileName)
                .setFileSize(fileSize)
                .setMd5(md5)
                .setCreateTime(new Date());

        uploadFileInfoRepository.insert(uploadFileInfo);

        return relativePath;
    }
}
