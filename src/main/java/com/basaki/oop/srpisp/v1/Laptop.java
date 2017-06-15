package com.basaki.oop.srpisp.v1;

public class Laptop
        implements IComputerDescription {
    private double price = 200;

    public String getDescription() {
        return "You get a Laptop";
    }

    public String getColor() {
        return "Color is Black and Red";
    }

    public double getPrice() {
        return price;
    }

    public double calculatePriceAfterTax() {
        return price + price * 0.20;
    }
}
