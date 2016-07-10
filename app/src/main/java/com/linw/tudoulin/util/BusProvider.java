package com.linw.tudoulin.util;

import com.squareup.otto.Bus;

/**
 * Bus的单例
 * 作者: linw
 * 时间: 16/6/12
 * 内容:
 */
public class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {

    }

}

