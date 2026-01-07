package com.designpatterns.adapter;

public class LoggerAdapter implements Logger{
    private OldXmlLogger oldLogger;

    public LoggerAdapter(OldXmlLogger logger){
        oldLogger = logger;
    }

    @Override
    public void log(String message) {
        String xml = "<log>" + message +"</log>";
       this.oldLogger.logXml(xml);
    }
}
