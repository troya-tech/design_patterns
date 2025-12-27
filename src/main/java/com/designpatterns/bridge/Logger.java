package com.designpatterns.bridge;

public abstract class Logger {
    protected LogOutput output;

    protected Logger(LogOutput output) {
        this.output = output;
    }

    public abstract void log(String message);
}
