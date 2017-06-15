package com.basaki.oop.srpisp.v1;

public class GiftItem
        implements IComputerDescription {
    public String getDescription() {
        return "Yes you get one PenDrive as a gigt item. Enjoy!";
    }

    public String getColor() {
        return "Choose any color from Red Black and White";
    }

    public double getPrice() {
        return 0;
    }

    public double calculatePriceAfterTax() {
        return 0;
    }
}
