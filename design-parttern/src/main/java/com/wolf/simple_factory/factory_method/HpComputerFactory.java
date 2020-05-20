package com.wolf.simple_factory.factory_method;

import com.wolf.simple_factory.Computer;
import com.wolf.simple_factory.HpComputer;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-26 14:56
 **/
public class HpComputerFactory implements Factory {
    @Override
    public Computer createComputer() {
        System.out.println("创建惠普电脑工厂");
        return new HpComputer();
    }
}
