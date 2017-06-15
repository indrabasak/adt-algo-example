package com.basaki.oop.ocpdip;

public class ComputerShop {
    public static void main(String[] args) {
        ComputerShop shop = new ComputerShop();
        System.out.println(shop.getDescription(ComputerType.DESKTOP));
    }

    public String getDescription(ComputerType type) {
        String desc = "";
        if (ComputerType.DESKTOP == type) {
            desc = new Desktop().getDescription();
        } else if (ComputerType.LAPTOP == type) {
            desc = new Laptop().getDescription();
        }
        return desc;
    }

    public enum ComputerType {
        DESKTOP, LAPTOP;
    }
}
