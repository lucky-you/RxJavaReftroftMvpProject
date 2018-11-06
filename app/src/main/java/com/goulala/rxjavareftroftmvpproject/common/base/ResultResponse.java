package com.goulala.rxjavareftroftmvpproject.common.base;

public class ResultResponse<T> {

    public String reason;
    public int error_code;
    public T result;

    @Override
    public String toString() {
        return "ResultResponse{" +
                "reason='" + reason + '\'' +
                ", error_code=" + error_code +
                ", result=" + result +
                '}';
    }
}
