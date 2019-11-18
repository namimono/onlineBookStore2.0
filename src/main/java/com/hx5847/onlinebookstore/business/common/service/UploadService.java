package com.hx5847.onlinebookstore.business.common.service;

import com.hx5847.onlinebookstore.config.result.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author GaoLiwei
 * @date 2019/7/25
 */
public interface UploadService {


    /**
     * 上传文件
     *
     * @param multipartFile 上传的文件
     * @param dir           详细文件夹
     * @return 返回信息
     */
    Result uploadFile(MultipartFile multipartFile, String dir);
}
