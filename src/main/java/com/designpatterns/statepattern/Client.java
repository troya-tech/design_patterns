package com.designpatterns.statepattern;


public class Client {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();

        System.out.println("Initial: " + trafficLight.getStateName());

        trafficLight.handle(Event.TIMER_EXPIRED);
        System.out.println("After timer: " + trafficLight.getStateName());

        trafficLight.handle(Event.TIMER_EXPIRED);
        System.out.println("After timer: " + trafficLight.getStateName());

        trafficLight.handle(Event.EMERGENCY);
        System.out.println("After emergency: " + trafficLight.getStateName());

        trafficLight.handle(Event.TIMER_EXPIRED);
        System.out.println("After timer: " + trafficLight.getStateName());
    }
}
