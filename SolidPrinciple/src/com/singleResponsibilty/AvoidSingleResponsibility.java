package com.singleResponsibilty;

 class Marker {

    String name;
    String color;
    int year;
    int price;


    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }


}


class Invoice{
     Marker marker;
     int quantity;


        public Invoice(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }

        public int calculateTotalPrice(){
            return marker.price * quantity;  // Reason 1 for not following Single Responsibility Principle
        }

        public void printInvoice(){
            System.out.println("Name: " + marker.name);
            System.out.println("Color: " + marker.color);  // Reason 2 for not following Single Responsibility Principle
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: " + calculateTotalPrice());
        }


        public  void  saveToDatabase(){
            System.out.println("Saving to database");  // Reason 3 for not following Single Responsibility Principle
        }


}



public class AvoidSingleResponsibility {
    public static void main(String[] args) {
        Marker marker = new Marker("Marker", "Red", 2021, 10);
        Invoice invoice = new Invoice(marker, 5);
        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}

