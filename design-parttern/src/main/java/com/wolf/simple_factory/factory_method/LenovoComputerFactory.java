package com.wolf.simple_factory.factory_method;

import com.wolf.simple_factory.Computer;
import com.wolf.simple_factory.LenovoComputer;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-26 15:11
 **/
public class LenovoComputerFactory implements Factory {
    @Override
    public Computer createComputer() {
        System.out.println("创建联想电脑工厂");
        return new LenovoComputer();
    }
}
