package com.designpatterns.bridgev2;

public class BasicRemote implements Remote {
    Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if (device.isEnabled()) device.disable();
        else device.enable();

    }
}
