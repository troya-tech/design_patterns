package com.designpatterns.adapter.v2;

public class LoggerAdapter implements Logger{
    OldXmlLogger oldLogger;

    public LoggerAdapter(OldXmlLogger logger){
        oldLogger = logger;
    }

    @Override
    public void log(String message) {
        String xml = "<log>" + message +"</log>";
       this.oldLogger.logXml(xml);
    }
}
