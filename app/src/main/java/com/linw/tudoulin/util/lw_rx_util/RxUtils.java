package com.linw.tudoulin.util.lw_rx_util;

import android.databinding.ObservableList;
import android.util.Log;

import java.util.Observer;

import rx.Observable;
import rx.Subscriber;

/**
 * 作者: linw
 * 时间: 16/8/13
 * 内容:
 */
public class RxUtils {

    private static final String TAG = RxUtils.class.getSimpleName();

    public static void createNewObaerable() {
        //穿件一个观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("hello");
                    subscriber.onNext("hi!");
                    subscriber.onCompleted();
                }
            }
        });

        Subscriber<String> subscriberSub = new Subscriber<String>() {
            @Override
            public void onCompleted() {
//                Log.i(TAG, "onCompleted");
                System.out.print("onCompleted\n");
            }

            @Override
            public void onError(Throwable e) {
//                Log.i(TAG, "onError:" + e.getMessage());
                System.out.print("onError:" + e.getMessage() + "\n");
            }

            @Override
            public void onNext(String s) {
//                Log.i(TAG, "onNext::" + s);
                System.out.print("onNext::" + s + "\n");
            }
        };

        observable.subscribe(subscriberSub);
    }
}
