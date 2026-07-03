package com.practice.practhread2;

public class PracThread2 {

    public static void main(String[] args) {
        var myThread = new Runnable() {
            @Override
            public void run() {
                System.out.println("Child thread is starting");
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Child thread is running " + i);
                        Thread.sleep(400);
                    }
                    System.out.println("Child thread is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        var thread = new Thread(myThread);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread is running " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
