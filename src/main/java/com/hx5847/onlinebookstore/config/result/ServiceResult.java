package com.hx5847.onlinebookstore.config.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author GaoLiWei
 * @date 2019/3/13
 * 增删改的service层返回值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResult {

    /**
     * mybaits增删改的返回结果
     */
    private Integer result;

    /**
     * 需要返回的对象
     */
    private Object object;

}
