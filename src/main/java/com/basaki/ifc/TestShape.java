package com.basaki.ifc;

public class TestShape {

    public static void main(String[] args) {
        //IShape shape = new IShape();
        IShape shape1 = new Rectangle();
        shape1.setLength(4);
        shape1.setWidth(3);
        System.out.println(shape1.getArea());
        Rectangle rect1 = new Rectangle();

        IShape shape2 = new Square();
        shape2.setLength(4);
        System.out.println(shape2.getArea());
    }

}
