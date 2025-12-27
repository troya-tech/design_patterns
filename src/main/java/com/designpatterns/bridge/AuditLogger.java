package com.designpatterns.bridge;

public class AuditLogger extends Logger {

    public AuditLogger(LogOutput output) {
        super(output);
    }

    @Override
    public void log(String message) {
        output.write("[AUDIT] " + message);
    }
}
