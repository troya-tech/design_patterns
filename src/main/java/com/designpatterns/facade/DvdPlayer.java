package com.designpatterns.facade;


class DvdPlayer {
    void on() {
        System.out.println("DVD Player ON");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    void off() {
        System.out.println("DVD Player OFF");
    }
}
