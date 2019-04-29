package com.example.demo.base;

/**
 * 应用异常通用封装
 */
public class CommonException extends RuntimeException {

    public static CommonException create(int code, String message) {
        return new CommonException(code, message);
    }

    private int code;
    private String message;

    private CommonException(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
