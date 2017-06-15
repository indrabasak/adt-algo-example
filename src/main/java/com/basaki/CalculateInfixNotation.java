package com.basaki;

import java.util.Stack;

public class CalculateInfixNotation {

    private static Integer execute(final Operator opr, final int b, final int a) {
        System.out.println("&&&&& " + a + b + opr.getSign());
        switch (opr) {
            case addition:
                return a + b;
            case subtraction:
                return a - b;
            case multiplication:
                return a * b;
            case division:
                return a / b;
            default:
                return null;
        }
    }

    public static double calculate(String expression) {
        Stack<Operator> operator = new Stack<Operator>();
        Stack<Integer> operand = new Stack<Integer>();

        boolean prevInt = false;
        for (int i = 0; i < expression.length(); i++) {
            final char k = expression.charAt(i);
            if (k == ' ') {
                continue;
            }
            try {
                final Operator opr = Operator.getOperatorforSign(k);
                prevInt = false;
                // System.out.println(opr.name());
                if (!operator.empty()) {
                    while (!operator.empty()
                            && (opr.getPriority() <= operator.peek()
                            .getPriority())) {
                        // postfix += stack.pop().getSign();
                        int b = operand.pop();
                        int a = operand.pop();
                        Operator o = operator.pop();
                        int result = execute(o, b, a);
                        System.out.println("&&&-1 " + a + ", " + b + " " + o
                                + " = " + result);
                        operand.push(result);
                    }
                }
                System.out.println("opr.sign: " + opr.sign);
                operator.push(opr);
                // System.out.println(stack);
            } catch (final IllegalArgumentException e) {
                int oprd = Integer.parseInt("" + k);
                if (prevInt) {
                    oprd = oprd + operand.pop() * 10;
                }
                System.out.println("oprd: " + oprd);
                operand.push(oprd);
                prevInt = true;
                // postfix += k;
            }
        }

        System.out.println("operator.size() = " + operator.size());
        while (!operator.isEmpty()) {
            int b = operand.pop();
            int a = operand.pop();
            Operator o = operator.pop();
            int result = execute(o, b, a);
            System.out.println("&&&-2 " + a + ", " + b + " " + o + " = "
                    + result);
            operand.push(result);
        }

        return operand.peek();
    }

    public static void main(String[] args) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + calculate("3*2+5*6"));
        System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + calculate("30*200+5*6"));

    }

    enum Operator {
        addition('+', 0), subtraction('-', 0), multiplication('*', 1), division(
                '/', 1);

        private final char sign;
        private final int priority;

        private Operator(final char sign, final int priority) {
            this.sign = sign;
            this.priority = priority;
        }

        public static Operator getOperatorforSign(final char sign) {
            for (final Operator opr : Operator.values()) {
                if (opr.getSign() == sign) {
                    return opr;
                }
            }
            throw new IllegalArgumentException();
        }

        public int getPriority() {
            return this.priority;
        }

        public char getSign() {
            return this.sign;
        }

    }

}
