package com.practice.sync3;

public class Sync3 {

    public static void main(String[] args) {
        // using partially summed values and thread to sum an array values
        // synchronizing on the same object to avoid race conditions
        int[] newArrays = { 2, 8, 2, 5, 7, 3, 1 };
        var thread3 = SumArrayThread.createAndStartThread(newArrays, 0, 4);
        var thread4 = SumArrayThread.createAndStartThread(newArrays, 4, 7);
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // System.out.println("Sum: " + (thread3.getSum() + thread4.getSum()));
        System.out.println("Sum: " + SumArrayThread.getSum());
    }
}

class SumArray {

    public int sumPartially(int[] arr, int start, int end) {
        int sum = 0;
        System.out.println(
            Thread.currentThread().getName() +
                " called with start=" +
                start +
                " stop=" +
                end
        );
        for (int i = start; i < end; i++) {
            sum += arr[i];
            System.out.println(
                Thread.currentThread().getName() +
                    " sum=" +
                    sum +
                    " i=" +
                    arr[i]
            );
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return sum;
    }
}

class SumArrayThread implements Runnable {

    private final int start;
    private final int stop;
    private final Thread thread;
    private final int[] arr;
    private static final SumArray sumArray = new SumArray();
    private static int totalSum;

    private SumArrayThread(int[] arr, int start, int stop) {
        this.arr = arr;
        this.start = start;
        this.stop = stop;
        this.thread = new Thread(this);
    }

    public static Thread createAndStartThread(int[] arr, int start, int stop) {
        var myThread = new SumArrayThread(arr, start, stop);
        myThread.thread.start();
        return myThread.thread;
    }

    @Override
    public void run() {
        var sum = sumArray.sumPartially(arr, start, stop);
        synchronized (SumArrayThread.class) {
            totalSum += sum;
            System.out.println(
                Thread.currentThread().getName() +
                    ": sumArrayThread finished" +
                    " sum: " +
                    sum +
                    " totalSum: " +
                    totalSum
            );
        }
    }

    public static int getSum() {
        return totalSum;
    }
}
