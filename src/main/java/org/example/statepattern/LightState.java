package org.example.statepattern;


public interface LightState {

    void handle(TrafficLight context, Event event);

    String name();
}
