package com.wolf.multhread.runnable;

public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("thread: " + name);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable("thread2"));
        thread.start();
    }
}
