package com.wolf.singleton;

public class Singleton {
    /**
     * volatile关键字的作用：
     * 由于对象赋值是非原子操作，volatile将对象赋值变为原子操作，没有初始化完，就不会刷新到主存。
     */
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
