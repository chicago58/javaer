package com.wolf.simple_factory.factory_method;

import com.wolf.simple_factory.AsusComputer;
import com.wolf.simple_factory.Computer;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-26 15:11
 **/
public class AsusComputerFactory implements Factory {
    @Override
    public Computer createComputer() {
        System.out.println("创建华硕电脑工厂");
        return new AsusComputer();
    }
}
