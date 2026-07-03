package com.practice.factorythreader;

class FactoryThreader {

    public static void main(String[] args) {
        var thread1 = MyThread.createAndStartThread("Child#1");

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Main Iteration " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread implements Runnable {

    private Thread thread;
    private String name;

    private MyThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
    }

    public static MyThread createAndStartThread(String name) {
        var myThread = new MyThread(name);
        myThread.thread.start();
        return myThread;
    }

    @Override
    public void run() {
        System.out.println("Thread is running");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " " + i);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
