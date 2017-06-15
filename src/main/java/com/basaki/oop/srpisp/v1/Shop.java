package com.basaki.oop.srpisp.v1;

public class Shop {
    public static void main(String[] args) {
        Shop shop = new Shop();
        System.out.println(shop.getMyComputerPrice(new Laptop()));
        System.out.println(shop.getAvailableColor(new Laptop()));
        System.out.println(shop.whatIsThecolorofGiftItem(new GiftItem()));
    }

    public String getMyComputer(IComputerDescription type) {
        // No matter how many types of computer comes
        return type.getDescription();
    }

    public String getMyComputerPrice(IComputerDescription type) {
        return "Price is " + type.calculatePriceAfterTax();
    }

    public String getAvailableColor(IComputerDescription type) {
        return type.getColor();
    }

    public String whatIsThecolorofGiftItem(IComputerDescription type) {
        return getAvailableColor(type);
    }

    public String isThereAnyGiftItem(IComputerDescription gftType) {
        return getMyComputer(gftType);
    }
}
