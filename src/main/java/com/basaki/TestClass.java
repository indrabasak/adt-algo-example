package com.basaki;


@SuppressWarnings({"squid:S1481", "squid:S2440", "squid:S106", "squid:S2209", "squid:S1854"})
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
            case 3:
                break;
            default:
                System.out.println("*****");
                break;
        }

    }

    public void overload() {
        //empty
    }

}
