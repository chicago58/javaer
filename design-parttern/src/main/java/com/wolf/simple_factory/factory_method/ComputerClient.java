package com.wolf.simple_factory.factory_method;

import com.wolf.simple_factory.Computer;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-26 15:12
 **/
public class ComputerClient {

    public static void main(String[] args) throws Exception {
        // 反射机制实例化工厂对象
        Factory hpComputerFactory = (Factory) Class.forName("com.wolf.simple_factory.factory_method.HpComputerFactory").newInstance();
        Factory lenovoComputerFactory = (Factory) Class.forName("com.wolf.simple_factory.factory_method.LenovoComputerFactory").newInstance();

        // 通过工厂对象创建对象实例
        Computer hpComputer = hpComputerFactory.createComputer();
        Computer lenovoComputer = lenovoComputerFactory.createComputer();

        hpComputer.start();
        lenovoComputer.start();
    }
}
