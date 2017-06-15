package com.basaki.oop.srpisp.liskov.v2;

public class QuadrilateralFactory {
    public static void main(String[] args) {
        QuadrilateralFactory factory = new QuadrilateralFactory();
        Quadrilateral q = factory.getQuadrilateral();
        q.setHeight(7);
        q.setWidth(3);
        q.getArea();
    }

    public Quadrilateral getQuadrilateral() {
        return new Square();
    }
}
