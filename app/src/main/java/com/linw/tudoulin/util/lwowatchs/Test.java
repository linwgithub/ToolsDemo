package com.linw.tudoulin.util.lwowatchs;

/**
 * 作者: linw
 * 时间: 16/8/12
 * 内容:
 */
public class Test {

    public static void main(String[] arg) throws Exception {
        Watched watched = new LWObservered();

        Watcher watcher_1 = new LWObserver();
        Watcher watcher_2 = new LWObserver();
        Watcher watcher_3 = new LWObserver();

        watched.addWatcher(watcher_1);
        watched.addWatcher(watcher_2);
        watched.addWatcher(watcher_3);

        watched.notifyWatchers("event begin\n");
    }
}
