package com.designpatterns.statepattern;


public class RedState implements LightState {

    @Override
    public void handle(TrafficLight context, Event event) {
        if (event == Event.TIMER_EXPIRED) {
            context.setState(new GreenState());
        }
        // emergency while RED -> stay RED (no-op)
    }

    @Override
    public String name() {
        return "RED";
    }
}
