package com.basaki.oop.srpisp.liskov.v1;

public class RectangleFactory {

    public static void main(String[] args) {
        RectangleFactory factory = new RectangleFactory();
        Rectangle r = factory.getRectangle();
        r.setWidth(7);
        r.setHeight(3);
        r.getArea();
        assert (r.getArea() == 9) : "1 - area  matches";
        assert (r.getArea() == 21) : "2 - area doesn't match";
    }

    public Rectangle getRectangle() {
        return new Square();
    }

}
