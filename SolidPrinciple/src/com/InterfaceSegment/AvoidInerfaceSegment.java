package com.InterfaceSegment;

public class AvoidInerfaceSegment {



    static class waiter implements Restaurent{

        @Override
        public void makeFood() {
            // waiter can not make the food so it is avoiding the rule of Interface Segregation Principle
        }

        @Override
        public void takeOrder() {
            System.out.println("Taking Order");
        }

        @Override
        public void washDishes() {
            System.out.println("Washing Dishes");
        }

    }

}



interface Restaurent{
    void makeFood();
    void takeOrder();
    void washDishes();


}

