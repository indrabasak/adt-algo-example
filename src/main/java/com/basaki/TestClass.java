package com.basaki;

//import static java.lang.*;

public class TestClass {

    //const int a;
    public TestClass() {
        // TODO Auto-generated constructor stub
    }

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
            default:
                System.out.println("*****");
            case 3:
        }

    }

    public void overload() {

    }

}
