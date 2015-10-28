package com.scienjus.model;

/**
 * 自定义请求状态码
 * @author ScienJus
 * @date 2015/7/15.
 */
public enum ResultStatus {
    SUCCESS(100, "成功");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
