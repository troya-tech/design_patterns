package com.designpatterns.statepattern;


public interface LightState {

    void handle(TrafficLight context, Event event);

    String name();
}
