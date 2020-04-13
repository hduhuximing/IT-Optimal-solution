package com.mi.learn;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/10 8:20 下午
 * @description 不用锁
 */
public class SingleTon {
    private static AtomicReference<SingleTon> instance = new AtomicReference<>();

    private SingleTon() {
    }

    ;

    public SingleTon getInstance() {
        for (; ; ) {
            SingleTon singleTon = instance.get();
            if (singleTon != null) {
                return singleTon;
            }
            singleTon = new SingleTon();
            if (instance.compareAndSet(null, singleTon)) {
                return singleTon;
            }
        }
    }
}
