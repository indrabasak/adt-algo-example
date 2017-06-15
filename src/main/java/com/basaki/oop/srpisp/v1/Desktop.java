package com.basaki.oop.srpisp.v1;

public class Desktop
        implements IComputerDescription {
    private double price = 110;

    public String getDescription() {
        return "You get a Desktop";
    }

    public String getColor() {
        return "Color is White";
    }

    public double getPrice() {
        return price;
    }

    public double calculatePriceAfterTax() {
        return price + price * 0.20;
    }
}
