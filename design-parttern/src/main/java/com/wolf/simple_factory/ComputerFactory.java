package com.wolf.simple_factory;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-25 21:28
 **/
public class ComputerFactory {

    public static Computer createComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "lenovo":
                computer = new LenovoComputer();
                break;
            case "hp":
                computer = new HpComputer();
                break;
            case "asus":
                computer = new AsusComputer();
                break;
        }
        return computer;
    }
}
