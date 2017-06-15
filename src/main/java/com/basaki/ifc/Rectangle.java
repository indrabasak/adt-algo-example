package com.basaki.ifc;

public class Rectangle implements IShape {

    private int length;
    private int width;

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int len) {
        length = len;

    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }


    public int getArea() {
        return length * width;
    }
}
