package com.goulala.rxjavareftroftmvpproject.common.base;

public class ResultResponse<T> {

    public int ret;
    public String msg;
    public T data;

    public ResultResponse(int code, String message, T result) {
        ret = code;
        msg = message;
        data = result;
    }
}
