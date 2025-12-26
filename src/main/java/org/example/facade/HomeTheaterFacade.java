package org.example.facade;


class HomeTheaterFacade {

    private final Amplifier amplifier;
    private final DvdPlayer dvdPlayer;
    private final Projector projector;

    public HomeTheaterFacade(
            Amplifier amplifier,
            DvdPlayer dvdPlayer,
            Projector projector
    ) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        amplifier.on();
        projector.on();
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.off();
        projector.off();
        amplifier.off();
    }
}
