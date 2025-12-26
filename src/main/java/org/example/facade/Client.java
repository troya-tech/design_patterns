package org.example.facade;


public class Client {
    public static void main(String[] args) {

        Amplifier amplifier = new Amplifier();
        DvdPlayer dvdPlayer = new DvdPlayer();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(amplifier, dvdPlayer, projector);

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
