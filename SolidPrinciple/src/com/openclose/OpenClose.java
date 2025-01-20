package com.openclose;


public class OpenClose {


    public static void main(String[] args) {

        Invoice invoice = new Invoice(new Marker("Marker", "Red", 2021, 10), 5);
        new InvoicePrinter().printInvoice(invoice);
        new InvoiceDatabase().save(invoice);
        new InvoiceFile().save(invoice);

    }
    // these all classes are tested and working fine for single Resplonsibility Principle
    // but if i have to add new feature like saving to database as well as in file  then we need to follow the second approach


}

// so i want to update the same invoice into file as well

// step one make a Interface

interface Invoicedao{
    void save(Invoice invoice);
}

class InvoiceDatabase  implements Invoicedao{

    @Override
    public void save(Invoice invoice) {
        System.out.println("Saving to database");
    }
}

class InvoiceFile implements Invoicedao{

    @Override
    public void save(Invoice invoice) {
        System.out.println("Saving to file");
    }
}

class InvoicePrinter{
    public void printInvoice(Invoice invoice){
        System.out.println("Name: " + invoice.marker.name);
        System.out.println("Color: " + invoice.marker.color);  // Reason 2 for not following Single Responsibility Principle
        System.out.println("Quantity: " + invoice.quantity);
        System.out.println("Total Price: " + invoice.calculateTotalPrice());
    }
}

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




}