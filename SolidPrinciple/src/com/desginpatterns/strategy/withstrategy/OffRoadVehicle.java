package com.desginpatterns.strategy.withstrategy;

import com.desginpatterns.strategy.withstrategy.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
