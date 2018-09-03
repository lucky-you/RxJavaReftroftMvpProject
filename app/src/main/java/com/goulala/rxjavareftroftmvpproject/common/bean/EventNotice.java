package com.goulala.rxjavareftroftmvpproject.common.bean;

/**
 * Created by: Z_B on 2018/8/26.
 * Function: EventBus的消息模版
 */
public class EventNotice {

    public int noticeType;
    public Object noticeOne;
    public Object noticeTwo;
    public Object noticeThree;

    public EventNotice(int noticeType) {
        this.noticeType = noticeType;
    }

    public EventNotice(int noticeType, Object noticeOne) {
        this.noticeType = noticeType;
        this.noticeOne = noticeOne;
    }

    public EventNotice(int noticeType, Object noticeOne, Object noticeTwo) {
        this.noticeType = noticeType;
        this.noticeOne = noticeOne;
        this.noticeTwo = noticeTwo;
    }

    public EventNotice(int noticeType, Object noticeOne, Object noticeTwo, Object noticeThree) {
        this.noticeType = noticeType;
        this.noticeOne = noticeOne;
        this.noticeTwo = noticeTwo;
        this.noticeThree = noticeThree;
    }
}
