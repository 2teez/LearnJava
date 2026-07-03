package com.practice.extendthread;

public class ExtendThread extends Thread {

    public static void main(String[] args) {
        System.out.println("Start Here");
        ExtendThread thread = new ExtendThread();
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main iteration " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Thread is running");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Iteration " + i);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
