package com.wolf.mediator;

public class MusicDevice extends SmartDevice {
    @Override
    public void readyState(String instruction) {
        System.out.println("音乐设备准备" + instruction);
    }

    @Override
    public void operateDevice(String instruction, SmartMediator mediator) {
        System.out.println("音乐设备已" + instruction);
        mediator.music(instruction);
    }
}
