package com.basaki.oop.srpisp.liskov.v2;

public class Rectangle
        extends Quadrilateral {
    public int getArea() {
        return getHeight() * getWidth();
    }
}
