package com.wolf.multhread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    public Integer call() throws Exception {
        Thread.currentThread().setName(name);
        System.out.println("thread: " + name);
        return 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> call = new MyCallable("thread3");
        /**
         * FutureTask实现RunnableFuture接口，RunnableFuture接口继承Runnable、Future接口
         * FutureTask实例启动线程执行任务
         */
        FutureTask<Integer> futureTask = new FutureTask<Integer>(call);

        Thread thread = new Thread(futureTask);
        thread.start();
        //获取线程返回结果
        Integer res = futureTask.get();
        System.out.println(res);
    }
}
