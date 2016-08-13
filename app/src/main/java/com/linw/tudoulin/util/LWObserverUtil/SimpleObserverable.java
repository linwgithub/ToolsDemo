package com.linw.tudoulin.util.lwobserverutil;

import java.util.Observable;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:被观察者
 */
public class SimpleObserverable extends Observable {

    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if (this.data != data) {
            this.data = data;
            notifyObservers();//通知观察者
        }
    }
}
