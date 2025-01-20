package com.desginpatterns.strategy.withstrategy;

import com.desginpatterns.strategy.withstrategy.strategy.NormalDriveStrategy;

public class PassangerVehicle extends Vehicle{

    public PassangerVehicle() {
        super(new NormalDriveStrategy());

    }

}
