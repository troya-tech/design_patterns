package com.designpatterns.statepattern;


public class YellowState implements LightState {

    @Override
    public void handle(TrafficLight context, Event event) {
        if (event == Event.TIMER_EXPIRED) {
            context.setState(new RedState());
        }
        // emergency during YELLOW -> immediately RED
        if (event == Event.EMERGENCY) {
            context.setState(new RedState());
        }
    }

    @Override
    public String name() {
        return "YELLOW";
    }
}
