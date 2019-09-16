package com.basaki.ifc;

@SuppressWarnings({"squid:S106"})
public class TestShape {

    public static void main(String[] args) {
        IShape shape1 = new Rectangle();
        shape1.setLength(4);
        shape1.setWidth(3);
        System.out.println(shape1.getArea());

        IShape shape2 = new Square();
        shape2.setLength(4);
        System.out.println(shape2.getArea());
    }

}
