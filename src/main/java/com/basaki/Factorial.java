package com.basaki;

@SuppressWarnings({"squid:S106", "squid:S1192"})
public class Factorial {

    public static void main(String[] args) {
        Factorial fac = new Factorial();
        System.out.println("Factorial of 3: " + fac.factorial(3));
        System.out.println("Factorial of 3: " + fac.factorial2(3));

        System.out.println("Factorial of 3: " + fac.factorial(8));
        System.out.println("Factorial of 3: " + fac.factorial2(8));
    }

    public int factorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    public int factorial2(int num) {
        if (num == 0) {
            return 1;
        }

        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }
}
