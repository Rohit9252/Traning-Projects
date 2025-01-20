package com.desginpatterns.strategy.withstrategy;

import com.desginpatterns.strategy.withstrategy.strategy.DriveStrategy;
import com.desginpatterns.strategy.withstrategy.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
