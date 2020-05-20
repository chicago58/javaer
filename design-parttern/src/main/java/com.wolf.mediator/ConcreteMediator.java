package com.wolf.mediator;

public class ConcreteMediator extends SmartMediator {
    public ConcreteMediator(SmartDevice bd, SmartDevice md, SmartDevice cd) {
        super(bd, md, cd);
    }

    @Override
    public void music(String instruction) {//音乐被唤醒后，使其他设备进入准备状态
        cd.readyState(instruction);//调用窗帘的准备方法
        bd.readyState(instruction);//调用洗浴设备的准备方法
    }

    @Override
    public void curtain(String instruction) {
        md.readyState(instruction);
        bd.readyState(instruction);
    }

    @Override
    public void bath(String instruction) {
        cd.readyState(instruction);
        md.readyState(instruction);
    }
}
