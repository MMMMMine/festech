package com.festech.webapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "upload_file_info")
public class UploadFileInfo {
    @Id
    private String id;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * 文件相对路径
     */
    @Column(name = "relative_path")
    private String relativePath;

    /**
     * 文件md5，用于区别文件是否已存在
     */
    private String md5;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

}