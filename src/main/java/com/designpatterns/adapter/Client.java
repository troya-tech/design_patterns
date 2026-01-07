package com.designpatterns.adapter;

// input[] -> adapater (logic) -> old input
// cesitli input tipleri, hedef input signature'a uymasi icin, gerekli logicin adapter class icinde saglanmasi.
// esb projesi temelinde proje olarak adapter implementasyonudur.

public class Client {
    public static void main(String[] args) {

        Logger logger = new LoggerAdapter(new OldXmlLogger());
        logger.log("some message");

    }
}
