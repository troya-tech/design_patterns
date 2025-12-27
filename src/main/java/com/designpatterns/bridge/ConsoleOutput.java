package com.designpatterns.bridge;

public class ConsoleOutput implements LogOutput {
    @Override
    public void write(String message) {
        System.out.println("Console: " + message);
    }
}
