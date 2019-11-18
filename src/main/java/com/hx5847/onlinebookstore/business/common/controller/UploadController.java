package com.hx5847.onlinebookstore.business.common.controller;

import com.hx5847.onlinebookstore.business.common.service.UploadService;
import com.hx5847.onlinebookstore.config.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件公共接口
 *
 * @author GaoLiwei
 * @date 2019/7/25
 */
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;


    //上传文件到临时文件公共接口
    @PostMapping("/uploadFileToTem")
    public Result uploadFileToTem(@RequestParam MultipartFile multipartFile, @RequestParam String dir, @RequestParam Integer flag) {
        return uploadService.uploadFile(multipartFile, dir,flag);
    }



}
