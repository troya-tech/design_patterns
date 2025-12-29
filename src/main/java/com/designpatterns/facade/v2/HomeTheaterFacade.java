package com.designpatterns.facade.v2;

import org.springframework.aop.config.AdvisorComponentDefinition;

public class HomeTheaterFacade {
    Tv tv;
    DvdPlayer dvdPlayer;

    public HomeTheaterFacade(Tv tv,DvdPlayer dvdPlayer) {
        this.tv = tv;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie(){
        this.tv.on();
        this.dvdPlayer.on();
    }
}
