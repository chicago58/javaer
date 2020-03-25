package com.wolf.simple_factory;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-25 21:31
 **/
public class ComputerClient {

    public static void main(String[] args) {
        ComputerFactory.createComputer("hp").start();
    }
}
