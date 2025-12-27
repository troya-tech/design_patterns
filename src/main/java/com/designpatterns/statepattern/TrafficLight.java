package com.designpatterns.statepattern;


public class TrafficLight {

    private LightState state;

    public TrafficLight() {
        this.state = new RedState(); // initial state
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public void handle(Event event) {
        state.handle(this, event);
    }

    public String getStateName() {
        return state.name();
    }
}
