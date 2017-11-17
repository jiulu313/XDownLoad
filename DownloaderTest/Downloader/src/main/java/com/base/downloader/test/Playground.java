package com.base.downloader.test;

import com.base.downloader.base.PriorityTaskQueue;

/**
 * 测试
 */

public class Playground {
    public static void main(String[] args){
        PriorityTaskQueue queue = new PriorityTaskQueue();
        queue.add(new Student("tom",45),45);
        queue.add(new Student("jim",33),33);
        queue.add(new Student("wendy",56),56);
        queue.add(new Student("selinx",45),455);

        while (!queue.isEmpty()){
            System.out.print(queue.poll().toString() + "  ");
        }

    }





}
