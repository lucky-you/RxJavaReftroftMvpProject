package com.goulala.rxjavareftroftmvpproject.common.base;

public class ResultResponse<T> {

    public String reason;
    public int error_code;
    public T result;

    public int code;
    public String msg;

}
