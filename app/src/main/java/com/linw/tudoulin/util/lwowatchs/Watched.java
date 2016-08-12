package com.linw.tudoulin.util.lwowatchs;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:
 */
public interface Watched {

    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers(String str);
}
