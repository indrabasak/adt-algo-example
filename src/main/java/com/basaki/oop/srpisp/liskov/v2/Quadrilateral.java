package com.basaki.oop.srpisp.liskov.v2;

public abstract class Quadrilateral {
    private int width;

    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract int getArea();
}
