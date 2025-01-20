package com.desginpatterns.strategy.withstrategy;

import com.desginpatterns.strategy.withstrategy.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }

}
