package com.practice.sync2;

public class Sync2 {

    public static void main(String[] args) {
        var arr = new int[] { 1, 2, 3, 4, 5 };
        var thread1 = SumArrayThread.createAndStartThread(arr);
        var thread2 = SumArrayThread.createAndStartThread(arr);
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SumArray {

    public int sumArray(int[] arr) {
        int sum = 0;
        System.out.println(
            Thread.currentThread().getName() + ": sumArray started"
        );
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Current value: " + arr[i] + " sum: " + sum);
            sum += arr[i];
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(
            Thread.currentThread().getName() + ": sumArray finished"
        );
        return sum;
    }
}

class SumArrayThread extends Thread {

    private final int[] arr;
    private int sum;
    private static final SumArray sumArray = new SumArray();

    private SumArrayThread(int[] arr) {
        this.arr = arr;
    }

    public static SumArrayThread createAndStartThread(int[] arr) {
        var myThread = new SumArrayThread(arr);
        myThread.start();
        return myThread;
    }

    @Override
    public void run() {
        synchronized (sumArray) {
            this.sum = sumArray.sumArray(arr);
            System.out.println(
                Thread.currentThread().getName() +
                    ": sumArrayThread finished" +
                    " sum: " +
                    this.sum
            );
        }
    }
}
