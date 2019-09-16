package com.basaki;

@SuppressWarnings({"squid:S106"})
public class Power {

    /**
     * Complexity:
     * <p>
     * <p>
     * <pre>
     * The time complexity of an algorithm gives an idea of the number of
     * operations needed to
     * solve it. While we shall discuss the time complexity issues in more
     * detail later, in this
     * section we work out the number of operations for the some of the
     * recursive functions that
     * we have developed so far. To do this we make use of recurrence relations.
     * A recurrence
     * relation, also known as a difference equation, is an equation which
     * defines a sequence
     * recursively: each term of the sequence is defined as a function of the
     * preceding terms.
     *
     * The problem size reduces from n to n � 1 at every stage, and at every
     * stage two arithmetic
     * operations are involved (one multiplication and one subtraction). Thus
     * total number of
     * operations needed to execute the function for any given n, can be
     * expressed as sum of 2
     * operations and the total number of operations needed to execute the
     * function for n-1.
     * Also when n=1, it just needs one operation to execute the function
     *
     * In other words T(n) can be expressed as sum of T(n-1) and two operations
     * using the
     * following recurrence relation:
     *
     * T(n) = T(n � 1 ) + 2
     * T(1) = 1
     *
     * We need to solve this to express T(n) in terms of n. The solution to the
     * recurrence
     * relation proceeds as follows. Given the relation
     * T(n) = T(n � 1 ) + 2 ..(1)
     *
     * we try to reduce the right hand side till we get to T(1) , whose solution
     * is known to us.
     * We do this in steps. First of all we note (1) will hold for any value of
     * n. Let us rewrite (1)
     * by replacing n by n-1 on both sides to yield
     *
     * T(n � 1 ) = T(n � 2 ) + 2 �(2)
     *
     * Substituting for T(n � 1 ) from relation (2) in relation (1) yields
     *
     * T(n ) = T(n � 2 ) + 2 (2) �(3)
     *
     * Also we note that
     *
     * T(n � 2 ) = T(n � 3 ) + 2 �(4)
     *
     * Substituting for T(n � 2 ) from relation(4) in relation (3) yields
     *
     * T(n ) = T(n � 3 ) + 2 (3) � (5)
     *
     * Following the pattern in relations (1) , (3) and (5), we can write a
     * generalized relation
     *
     * T(n ) = T(n � k ) + 2(k) �(6)
     *
     * To solve the generalized relation (6), we have to find the value of k. We
     * note that T(1) ,
     * that is the number of operations needed to raise a number x to power 1
     * needs just one
     * operation. In other words
     *
     * T(1) = 1 ...(7)
     *
     * We can reduce T(n-k) to T(1) by setting
     *
     * n � k = 1
     *
     * and solve for k to yield
     *
     *  k = n � 1
     *
     * Substituting this value of k in relation (6), we get
     *
     * T(n) = T(1) + 2(n � 1 )
     *
     * Now substitute the value of T(1) from relation (7) to yield the solution
     *
     * T(n) = 2n� 1 ..(8)
     *
     * When the right hand side of the relation does not have any terms
     * involving T(..), we say
     * that the recurrence relation has been solved. We see that the algorithm
     * is linear in n.
     * </pre>
     *
     * @param x
     * @param n
     * @return
     */
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));

    }

}
