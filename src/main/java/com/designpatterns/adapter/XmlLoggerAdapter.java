package com.designpatterns.adapter;


public class XmlLoggerAdapter implements Logger {

    private final LegacyXmlLogger legacyXmlLogger;

    public XmlLoggerAdapter(LegacyXmlLogger legacyXmlLogger) {
        this.legacyXmlLogger = legacyXmlLogger;
    }

    @Override
    public void log(String message) {
        String xml = "<log>" + message + "</log>";
        legacyXmlLogger.logXml(xml);
    }
}
