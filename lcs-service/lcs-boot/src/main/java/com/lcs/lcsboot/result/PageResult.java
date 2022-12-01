package com.lcs.lcsboot.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页响应结构体
 *
 * @author haoxr
 * @date 2022/2/18 23:29
 */
@Data
public class PageResult<T> implements Serializable {

    private String code;

    private Data data;

    private String msg;



    @lombok.Data
    public static class Data<T> {

        private List<T> list;

        private long total;

    }

}
