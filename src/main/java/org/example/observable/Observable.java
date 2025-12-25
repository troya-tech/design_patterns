package org.example.observable;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observerList;

    public Observable() {
        observerList = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observerList.remove(observer);
    }


    public void notifyIt() {
        for (Observer o : observerList) {
            o.update(this);
        }
    }
}
