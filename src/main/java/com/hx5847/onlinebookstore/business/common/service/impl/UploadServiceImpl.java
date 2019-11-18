package com.hx5847.onlinebookstore.business.common.service.impl;

import com.hx5847.onlinebookstore.business.common.model.UploadDto;
import com.hx5847.onlinebookstore.business.common.service.UploadService;
import com.hx5847.onlinebookstore.config.result.Result;
import com.hx5847.onlinebookstore.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author GaoLiwei
 * @date 2019/7/25
 */
@Service
public class UploadServiceImpl implements UploadService {

    /**
     * 临时文件的目录
     */
    @Value("${file.temporaryFile}")
    private String temporaryFilePath;

    /**
     * 临时文件的目录
     */
    @Value("${file.realFile}")
    private String realFile;

    /**
     * 临时文件回显地址
     */
    @Value("${file.temPrefix}")
    private String temPrefix;

    /**
     * 真实文件回显地址
     */
    @Value("${file.prefix}")
    private String prefix;

    @Override
    public Result uploadFile(MultipartFile multipartFile, String dir) {

        //图片保存的id
        String fileId = Utils.getUUID();
        //获得处理后的文件名
        String fileName = Utils.getFileSaveName(multipartFile, fileId);
        //临时文件
        //保存的文件路径
        String datePath = Utils.getNowFormat(new Date());
        String filePath = temporaryFilePath + "/" + datePath + "/" + fileName;
        if (copyFile(multipartFile, filePath)) {
            return Result.result(0, "上传成功", "上传失败");
        }
        return Result.result(1, "上传成功", "上传失败", new UploadDto(fileName, temPrefix + datePath + "/" + fileName));

//        //正式文件
//        if (flag == 2) {
//            //保存的文件路径
//            String filePath = realFile + "/" + dir + "/" + fileName;
//            if (copyFile(multipartFile, filePath)) {
//                return Result.result(0, "上传成功", "上传失败");
//            }
//            return Result.result(1, "上传成功", "上传失败", new UploadDto(fileName, prefix + dir + "/" + fileName));
//        }

    }


    private boolean copyFile(MultipartFile multipartFile, String filePath) {
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
