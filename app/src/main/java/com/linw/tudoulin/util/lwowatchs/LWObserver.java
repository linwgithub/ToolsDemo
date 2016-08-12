package com.linw.tudoulin.util.lwowatchs;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:
 */
public class LWObserver implements Watcher {

    @Override
    public void update(String str) {
        System.out.print(str);
    }
}
