package com.base.downloader.base;

/**
 * Created by zhanghongjun on 2017/11/17.
 */

public interface TaskQueue<E> {
    void add(E element);

    void add(E element,int priority);

    E poll();

    boolean isEmpty();

    int size();
}
