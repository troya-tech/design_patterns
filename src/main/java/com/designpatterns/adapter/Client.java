package com.designpatterns.adapter;

public class Client {
        public static void main(String[] args) {
        Logger logger = new XmlLoggerAdapter(new LegacyXmlLogger());
        logger.log("User logged in");
    }
}
