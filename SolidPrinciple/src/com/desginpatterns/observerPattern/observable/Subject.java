package com.desginpatterns.observerPattern.observable;

import com.desginpatterns.observerPattern.observer.Observer;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
