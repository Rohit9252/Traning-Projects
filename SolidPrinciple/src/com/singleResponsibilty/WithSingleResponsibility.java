package com.singleResponsibilty;

public class WithSingleResponsibility {


    public static void main(String[] args) {

        Invoice invoice = new Invoice(new Marker("Marker", "Red", 2021, 10), 5);
        new InvoicePrinter().printInvoice(invoice);
        new InvoiceDatabase().saveToDatabase();



    }

    // now the below classes are following Single Responsibility Principle
    // each class is doing only one thing


    private static class Marker {

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


    private static class Invoice{
        Marker marker;
        int quantity;


        public Invoice(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }



        public int calculateTotalPrice(){
            return marker.price * quantity;  // Reason 1 for not following Single Responsibility Principle
        }




    }



    private static class InvoicePrinter{
        public void printInvoice(Invoice invoice){
            System.out.println("Name: " + invoice.marker.name);
            System.out.println("Color: " + invoice.marker.color);  // Reason 2 for not following Single Responsibility Principle
            System.out.println("Quantity: " + invoice.quantity);
            System.out.println("Total Price: " + invoice.calculateTotalPrice());
        }
    }



    private  static class InvoiceDatabase{
        public  void  saveToDatabase(){
            System.out.println("Saving to database");  // Reason 3 for not following Single Responsibility Principle
        }
    }





}


