package com.hx5847.onlinebookstore.business.common.service;

import java.io.IOException;

/**
 * @author GaoLiwei
 * @date 2019/7/25
 */
public interface FileHandle {

    /**
     * 将正式文件删掉
     *
     * @param deleteFileNeed 要删除的文件
     * @param deleteFilePath 要删除的文件的路径
     * @throws IOException
     */
    void deleteFile(String[] deleteFileNeed, String deleteFilePath);

    /**
     * 将正式文件删掉
     *
     * @param realPath  正式文件目录
     * @param filePaths 需要删除的文件
     * @throws IOException
     */
    void deleteFile(String realPath, String... filePaths);


    /**
     * 将暂存的文件复制到正式文件夹中
     *
     * @param copyFileNeed 要进行移动的文件
     * @param aimFilePath  文件的目标地址
     * @throws IOException
     */
    void copyFile(String[] copyFileNeed, String aimFilePath);

    /**
     * 将暂存的文件复制到正式文件夹中
     *
     * @param realPath  正式文件目录
     * @param filePaths 需要移动的文件
     * @throws IOException
     */
    void copyFile(String realPath, String... filePaths);
}
