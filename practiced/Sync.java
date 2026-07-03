package com.practice.sync;

import static java.lang.System.out;

class Sync {

    public static void main(String[] args) {
        var arr = new int[] { 1, 2, 3, 4, 5 };
        var thread1 = MyThread.createAndStart("Thread 1", arr);
        var thread2 = MyThread.createAndStart("Thread 2", arr);
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

class SumArray {

    public synchronized int sumArray(int[] arr) {
        var sum = 0;
        for (var num : arr) {
            sum += num;
            out.println(
                "Running total by " +
                    Thread.currentThread().getName() +
                    " current num to add: " +
                    num +
                    ", sum: " +
                    sum
            );
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        return sum;
    }
}

class MyThread implements Runnable {

    private final String name;
    private final int[] arr;
    private final Thread thread;
    private static final SumArray sa = new SumArray();

    private MyThread(String name, int[] arr) {
        this.name = name;
        this.arr = arr;
        this.thread = new Thread(this, name);
    }

    public static Thread createAndStart(String name, int[] arr) {
        var mythread = new MyThread(name, arr);
        mythread.thread.start();
        return mythread.thread;
    }

    @Override
    public void run() {
        out.println(thread.getName() + " is running");

        var sum = sa.sumArray(arr);
        out.println(thread.getName() + " sum: " + sum);
    }
}
