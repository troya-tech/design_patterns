package com.designpatterns.observable;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Consumer> observerList;

    public Observable() {
        observerList = new ArrayList<>();
    }

    public void subscribe(Consumer observer) {
        observerList.add(observer);
    }

    public void unsubscribe(Consumer observer) {
        observerList.remove(observer);
    }


    public void notifyIt() {
        for (Consumer o : observerList) {
            o.update(this);
        }
    }
}
