package org.example.bridge;

public class AppLogger extends Logger {

    public AppLogger(LogOutput output) {
        super(output);
    }

    @Override
    public void log(String message) {
        output.write("[APP] " + message);
    }
}
