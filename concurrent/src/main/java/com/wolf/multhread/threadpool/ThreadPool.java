package com.wolf.multhread.threadpool;

import com.wolf.multhread.callable.MyCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    private static int taskSize = 5;

    /**
     * ExecutorService是实现线程池经常使用的接口，包括线程池、定时任务线程池
     * 接口ExecutorService继承了Executor
     *
     * Executors工厂类提供返回各种线程池实例的方法
     */
    private static ExecutorService service = Executors.newFixedThreadPool(taskSize);

    private static List<Future> array = new ArrayList<Future>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < taskSize; i++) {
            MyCallable call = new MyCallable("thread pool " + i);
            //将Callable接口添加到线程池中运行，获取返回结果存储到List中
            Future<Integer> future = service.submit(call);
            array.add(future);
        }

        //shutdown后，线程池不会再接收新的线程
        service.shutdown();
        System.out.println("shut down the thread pool.");

        //获取任务返回值
        for (Future future : array) {
            System.out.println(future.get().toString());
        }
    }
}
