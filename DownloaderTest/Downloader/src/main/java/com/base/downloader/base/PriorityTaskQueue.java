package com.base.downloader.base;

import com.base.downloader.exception.ArgumentException;
import com.base.downloader.tools.Precondition;

/**
 * Created by zhanghongjun on 2017/11/17.
 */

public class PriorityTaskQueue<E> implements TaskQueue<E> {
    public static final int DEFAULT_CAPACITY = 16;

    Node[] data;
    int size;
    int capacity;


    public PriorityTaskQueue() {
        this(DEFAULT_CAPACITY);
    }

    public PriorityTaskQueue(int capacity) {
        if (capacity <= 0)
            throw new ArgumentException("capacity must be <= 0");

        //从1的位置开始存
        data = new Node[capacity + 1];
        size = 0;
        this.capacity = capacity;
    }

    static class Node<E> {
        int priority;   // 0 - 10 数字越大优先级越高
        E element;

        public Node() {
            priority = -1;
            element = null;
        }

        public Node(E element, int priority) {
            this.element = element;
            this.priority = priority;
        }
    }

    //将第k个元素向下翻
    private void shiftDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && data[j + 1].priority > data[j].priority) {
                j = j + 1;
            }

            if (data[k].priority >= data[j].priority) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    //对索引为k的节点向上翻
    private void shiftUp(int k) {
        while (k > 1 && data[k].priority > data[k / 2].priority) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int m, int n) {
        Node temp = data[m];
        data[m] = data[n];
        data[n] = temp;
    }

    private void checkCapacity() {
        //扩容
    }

    //生成优先级
    private int makeNextPriority() {
        return 0;
    }

    @Override
    public void add(E element) {
        add(element, makeNextPriority());
    }

    @Override
    public void add(E element, int priority) {
        Precondition.checkNotNull(element,"element must be not null");

        checkCapacity();
        data[size + 1] = new Node(element, priority);
        size++;
        shiftUp(size);
    }

    @Override
    public E poll() {
        Node result = data[1];
        swap(1, size);
        size--;
        shiftDown(1);
        return (E) result.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


}
