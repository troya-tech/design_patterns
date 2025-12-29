package com.designpatterns.facade.v2;

public class Client {
    public static void main(String[] args) {
        Tv tv = new Tv();
        DvdPlayer dvdPlayer = new DvdPlayer();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(tv, dvdPlayer);

        homeTheaterFacade.watchMovie();
    }
}
