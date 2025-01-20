package com.desginpatterns.observerPattern;

import com.desginpatterns.observerPattern.observable.NewsAgency;
import com.desginpatterns.observerPattern.observer.NewsChannelObserver;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {


        NewsAgency newsAgency = new NewsAgency();

        NewsChannelObserver newsChannelObserver1 = new NewsChannelObserver("News Channel 1");
        NewsChannelObserver newsChannelObserver2 = new NewsChannelObserver("News Channel 2");
        NewsChannelObserver newsChannelObserver3 = new NewsChannelObserver("News Channel 3");


        newsAgency.registerObserver(newsChannelObserver1);
        newsAgency.registerObserver(newsChannelObserver2);
        newsAgency.registerObserver(newsChannelObserver3);


        newsAgency.setNews("Breaking: Major tech announcement!");
        newsAgency.setNews("News 2");

        newsAgency.removeObserver(newsChannelObserver2);

        newsAgency.setNews("Weather: Sunny day ahead!");

//        Collections

//        BlockingQueue bq = new Queue<>()

//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        Collections.unm

    }
}
