package com.basaki.oop.srpisp.liskov.v2;

public class Square extends Quadrilateral {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    public int getArea() {
        return getHeight() * getWidth();
    }
}
