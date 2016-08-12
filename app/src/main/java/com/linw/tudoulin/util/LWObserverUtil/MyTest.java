package com.linw.tudoulin.util.LWObserverUtil;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:
 */
public class MyTest {

    public static void main(String[] arg) throws Exception {
        SimpleObserverable observerable = new SimpleObserverable();
        SimpleObserver observer = new SimpleObserver(observerable);

        observerable.setData(1);
        observerable.setData(2);
        observerable.setData(2);
        observerable.setData(3);
    }
}
