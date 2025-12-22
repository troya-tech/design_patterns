package org.example.statepattern;


public class GreenState implements LightState {

    @Override
    public void handle(TrafficLight context, Event event) {
        switch (event) {
            case TIMER_EXPIRED -> context.setState(new YellowState());
            case EMERGENCY -> context.setState(new RedState());
        }
    }

    @Override
    public String name() {
        return "GREEN";
    }
}
