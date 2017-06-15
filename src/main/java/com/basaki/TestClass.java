package com.basaki;


public class TestClass {

    public static void main(String[] args) {
        System.out.println("88888888888");
        ClassA a = new ClassA();
        System.out.println(a.str);
        ClassB b = new ClassB();
        System.out.println(b.str);
        ClassA c = new ClassB();
        System.out.println(c.str);
        int x = 3;
        int tb = 5;
        int xy = 5;
        switch (x) {
            case 5:
                System.out.println("*****");
                break;
            default:
                System.out.println("*****");
                break;
            case 3:
        }

    }

    public void overload() {

    }

}
