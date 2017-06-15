package com.basaki;

/**
 * Xorshift random number generators form a class of pseudo-random number
 * generators that was discovered by George Marsaglia. They generate the next
 * number in their sequence by repeatedly taking the exclusive or of a number
 * with a bit shifted version of itself. This makes them extremely fast on
 * modern computer architectures.
 * <p>
 * There is no boolean operator counterpart to bitwise exclusive-or, but there
 * is a simple explanation. The exclusive-or operation takes two inputs and
 * returns a 1 if either one or the other of the inputs is a 1, but not if both
 * are. That is, if both inputs are 1 or both inputs are 0, it returns 0.
 * Bitwise exclusive-or, with the operator of a carrot, ^, performs the
 * exclusive-or operation on each pair of bits. Exclusive-or is commonly
 * abbreviated XOR.
 * <p>
 * <pre>
 * 01110010 ^
 * 10101010
 * --------
 * 11011000
 * </pre>
 *
 * @author web
 */
public class XORShiftRandom {

    private long last;

    public XORShiftRandom() {
        this(System.currentTimeMillis());
    }

    private XORShiftRandom(long seed) {
        this.last = seed;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int nextInt(int max) {
        // left shift 21 and XOR
        last ^= (last << 21);
        // The unsigned right shift operator ">>>" shifts a zero into the
        // leftmost position
        last ^= (last >>> 35);
        last ^= (last << 4);
        int out = (int) last % max;
        return (out < 0) ? -out : out;
    }

}
