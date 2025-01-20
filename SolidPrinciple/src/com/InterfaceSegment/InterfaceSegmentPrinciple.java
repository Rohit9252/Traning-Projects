package com.InterfaceSegment;

public class InterfaceSegmentPrinciple {


    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.takeOrder();
        waiter.serverOrder();

        Chef chef = new Chef();
        chef.makeFood();

        Helper helper = new Helper();
        helper.washDishes();
    }






}
//1. so each interface can have only relevant methods


// 2. so we can implement the interface in the class which is relevant to the Employee


class Waiter implements Restarentwaiter{

    @Override
    public void takeOrder() {
        System.out.println("Taking Order");
    }

    @Override
    public void serverOrder() {
        System.out.println("Serving Order");
    }

}

class Chef implements RestarentChef{

    @Override
    public void makeFood() {
        System.out.println("Making Food");
    }

}


class Helper implements RestarentHelper{

    @Override
    public void washDishes() {
        System.out.println("Washing Dishes");
    }

}


interface Restarentwaiter{
    void takeOrder();
    void serverOrder();

}



interface RestarentChef{
    void makeFood();


}


interface RestarentHelper{
    void washDishes();

}

