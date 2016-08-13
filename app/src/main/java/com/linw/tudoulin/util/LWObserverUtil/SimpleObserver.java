package com.linw.tudoulin.util.lwobserverutil;

import java.util.Observable;
import java.util.Observer;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:
 */
public class SimpleObserver implements Observer {

    public SimpleObserver(SimpleObserverable observerable) {
        observerable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
//        int data = ((SimpleObserverable) observable).getData();
        System.out.print("data update:" + "\n");
    }
}
