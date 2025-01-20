package com.desginpatterns.observerPattern.observable;

import com.desginpatterns.observerPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency  implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    private String news;



    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(news);
        }
    }


    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }


}
