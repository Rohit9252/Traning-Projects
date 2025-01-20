package com.desginpatterns.observerPattern.observer;

public class NewsChannelObserver implements Observer {
    private final String channelName;

    public NewsChannelObserver(String channelName) {
        this.channelName = channelName;
    }


    @Override
    public void update(String news) {
        System.out.println(channelName + " received news: " + news);
    }
}
