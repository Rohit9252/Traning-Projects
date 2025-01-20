package com.desginpatterns.strategy.withstrategy.strategy;




public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving Sports Vehicle");
    }
}
