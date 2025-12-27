package com.designpatterns.observable;

public class Client {

    public static void main(String[] args) {
        Double min = 23.0;
        Double max = 28.0;

        Termometre termometre = new Termometre(min, max);

        Subscriber anne = new Subscriber("Anne");
        termometre.subscribe(anne);

        for(int i = termometre.getCurrentSicaklik().intValue(); i<30;i++){
            termometre.setCurrentSicaklik((double) i);
        }

        for(int i = termometre.getCurrentSicaklik().intValue(); i>22;i--){
            termometre.setCurrentSicaklik((double) i);
        }
    }
}
