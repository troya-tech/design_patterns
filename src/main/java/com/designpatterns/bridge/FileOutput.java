package com.designpatterns.bridge;

public class FileOutput implements LogOutput {
    @Override
    public void write(String message) {
        System.out.println("File: " + message);
        // real impl → write to file
    }
}
