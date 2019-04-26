package com.example.demo.util;

import com.example.demo.base.Result;

/**
 * 请求返回结果同一封装处理
 */
public class ResultUtil {

    public static final int RESULT_SUCCESS = 20000;

    /**
     * 返回请求成功结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(RESULT_SUCCESS);
        result.setMessage("");
        result.setData(data);
        return result;
    }

    /**
     * 返回请求成功结果
     *
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data, String msg) {
        Result<T> result = new Result<>();
        result.setCode(RESULT_SUCCESS);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    /**
     * 返回请求失败结果
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
