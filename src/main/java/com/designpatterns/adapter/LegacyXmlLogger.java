package com.designpatterns.adapter;


public class LegacyXmlLogger {

    public void logXml(String xmlMessage) {
        System.out.println("Logging XML: " + xmlMessage);
    }
}
