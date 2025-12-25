package org.example.observable;

public class Termometre extends Observable{
    private Double currentSicaklik;
    private Double minSicaklik;
    private Double maxSicaklik;

    public Termometre(Double minSicaklik, Double maxSicaklik){
        this.currentSicaklik = 24.0;
        this.maxSicaklik = maxSicaklik;
        this.minSicaklik = minSicaklik;
    }

    public Double getCurrentSicaklik(){
        return currentSicaklik;
    }

    public void setCurrentSicaklik(Double currentSicaklik){
        this.currentSicaklik =currentSicaklik;
        checkTemperature();
    }

    private void checkTemperature(){

        boolean isHot = currentSicaklik.compareTo(maxSicaklik) >= 0;
        boolean isCold = currentSicaklik.compareTo(minSicaklik) <= 0;

        if(isCold || isHot) notifyIt();
    }
}
