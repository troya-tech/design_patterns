package com.designpatterns.bridgev2;

public class Tv implements Device {
    private boolean isOn = false;

    @Override
    public boolean isEnabled() {
        return isOn;
    }

    @Override
    public void enable() {
        isOn = true;
    }

    @Override
    public void disable() {
        isOn = false;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "isOn=" + isOn +
                '}';
    }
}
