package com.basaki;

import java.util.Stack;

@SuppressWarnings({"squid:S106", "squid:S1149"})
public class CalculateInfixNotation {

    private static Integer execute(final Operator opr, final int b,
                                   final int a) {
        System.out.println("&&&&& " + a + b + opr.getSign());
        switch (opr) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                return a / b;
            default:
                return null;
        }
    }

    public static double calculate(String expression) {
        Stack<Operator> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        boolean prevInt = false;
        for (int i = 0; i < expression.length(); i++) {
            final char k = expression.charAt(i);
            if (k == ' ') {
                continue;
            }
            try {
                final Operator opr = Operator.getOperatorforSign(k);
                prevInt = false;
                if (!operator.empty()) {
                    while (!operator.empty()
                            && (opr.getPriority() <= operator.peek()
                            .getPriority())) {
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
            } catch (final IllegalArgumentException e) {
                int oprd = Integer.parseInt("" + k);
                if (prevInt) {
                    oprd = oprd + operand.pop() * 10;
                }
                System.out.println("oprd: " + oprd);
                operand.push(oprd);
                prevInt = true;
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
        ADDITION('+', 0),
        SUBTRACTION('-', 0),
        MULTIPLICATION('*', 1),
        DIVISION('/', 1);

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
