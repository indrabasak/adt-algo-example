package com.basaki.oop.srpisp.liskov.v2;

public class Square
        extends Quadrilateral {
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    public int getArea() {
        return getHeight() * getWidth();
    }
}
