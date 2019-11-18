package com.hx5847.onlinebookstore.business.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GaoLiwei
 * @date 2019/8/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadDto {

    /**
     * 文件名称
     */
    private String name;

    /**
     * 处理好的文件路径
     */
    private String url;
}
