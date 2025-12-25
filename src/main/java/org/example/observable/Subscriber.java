package org.example.observable;

public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name){
        this.name=name;
    }

    @Override
    public void update(Observable observable) {
        Termometre termometre = (Termometre) observable;
        System.out.println(name + " : " + termometre.getCurrentSicaklik());
    }
}
