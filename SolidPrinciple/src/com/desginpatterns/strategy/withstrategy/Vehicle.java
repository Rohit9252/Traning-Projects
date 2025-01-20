package com.desginpatterns.strategy.withstrategy;

import com.desginpatterns.strategy.withstrategy.strategy.DriveStrategy;

public class Vehicle {


    private final DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }


    public void drive() {
        driveStrategy.drive();
    }




}
