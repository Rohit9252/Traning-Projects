package com.liskov;

public class AvoidLiskov {


    public static void main(String[] args) {

        // so we are narrow downing the parent class

        // sp for that we have ralevent method in parent class like below



    }

    // so we are following Liskov Substitution Principle
    static class vehicle{

        int numberOfWheels(){
            return 2;
        }
    }

    static class EngineVehicle extends vehicle{

        boolean startEngine(){
            return true;
        }
    }


    static class Car extends EngineVehicle{

        @Override
        int numberOfWheels(){
            return 4;
        }
    }

    static class Bike extends vehicle{

        @Override
        int numberOfWheels(){
            return 2;
        }
    }


    static  class Cycle extends vehicle{

        @Override
        int numberOfWheels(){
            return 2;
        }
    }

// below are those classes which are not following Liskov Substitution Principle



//    static class vehicle{
//        boolean startEngine(){
//           return true;
//        }
//        int numberOfWheels(){
//            return 2;
//        }
//    }
//
//
//    static class Car extends vehicle{
//
//        @Override
//        int numberOfWheels(){
//            return 4;
//        }
//    }
//
//
//    static class Bike extends vehicle{
//
//        @Override
//        int numberOfWheels(){
//            return 2;
//        }
//
//    }
//
//
//    static class Cycle extends vehicle{
//        @Override
//        public boolean startEngine(){
//            return null;
//        }
//
//    }

}
