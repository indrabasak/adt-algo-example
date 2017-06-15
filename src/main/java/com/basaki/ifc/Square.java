package com.basaki.ifc;

public class Square implements IShape {

    private int length;

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
        return length;
    }

    @Override
    public void setWidth(int width) {
        length = width;

    }

    @Override
    public int getArea() {
        return length * length;
    }

}
