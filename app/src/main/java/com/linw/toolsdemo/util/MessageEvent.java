package com.linw.toolsdemo.util;

/**
 * 定义Event事件，用来封装时间的信息
 * 作者: linw
 * 时间: 16/6/12
 * 内容:
 */
public class MessageEvent {
    public String msg;
    public Object obj;

    public MessageEvent(String msg, Object obj) {
        this.msg = msg;
        this.obj = obj;
    }
}
