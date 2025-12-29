package com.designpatterns.adapter.v2;

public class Client {
    public static void main(String[] args) {

        Logger logger = new LoggerAdapter(new OldXmlLogger());
        logger.log("some message");

    }
}
