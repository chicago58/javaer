package com.wolf.multhread.thread;

public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("thread: " + name);
    }

    public static void main(String[] args) {
        Thread thread = new MyThread("thread1");
        thread.start();
    }
}
