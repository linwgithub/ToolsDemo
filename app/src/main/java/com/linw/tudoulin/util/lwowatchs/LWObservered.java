package com.linw.tudoulin.util.lwowatchs;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:
 */
public class LWObservered implements Watched {

    List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(list);
    }

    @Override
    public void notifyWatchers(String str) {
        for (Watcher watcher : list) {
            watcher.update(str);
        }
    }
}
