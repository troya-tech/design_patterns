package org.example.bridge;

public class Client {
    public static void main(String[] args) {

        Logger appConsoleLogger =
                new AppLogger(new ConsoleOutput());

        Logger auditFileLogger =
                new AuditLogger(new FileOutput());

        appConsoleLogger.log("Application started");
        auditFileLogger.log("User logged in");
    }
}
