package com.desginpatterns.strategy.withstrategy;

public class Main {

    public static void main(String[] args) {


        Vehicle passangerVehicle = new PassangerVehicle();
        Vehicle offRoadVehicle = new OffRoadVehicle();
        Vehicle sportsVehicle = new SportsVehicle();

        passangerVehicle.drive();
        offRoadVehicle.drive();
        sportsVehicle.drive();


    }


}
