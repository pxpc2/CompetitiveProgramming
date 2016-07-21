package util;

/**
 * @author Pedro Daia
 */
public class Math {

    /**
     * See 'int add(int, int) , (II)I {method desc asm}'
     *
     * @param n1 first integer  'x'
     * @param n2 second integer 'y'
     * @return x - y
     *         note: x - y = x + y * -1; hence the use of add method
     */
    public static int sub(int n1, int n2) {
        return add(n1, -n2);
    }

    /**
     *
     * @param n1 first integer  'x'
     * @param n2 second integer 'y'
     * @return x + y
     */
    public static int add(int n1, int n2) {
        /*
         * First need to note that:
         * n1 + n2 = 2 * (n1&n2)+(n1^n2)
         */

        /*
         * Note about the & (AND) op:
         *
         * This operator basically "captures" the intersection of
         * the bit sequences against which it is applied.
         * For example, 9 & 13 = 1001 & 1101 = 1001 (=9).
         * You can see from this result that only those bits common to
         * both bit sequences are copied to the result.
         * It derives from this that when two bit
         * sequences have no common bit,
         * the result of applying '&' on them yields 0.
         */

        int xor, and, temp;
        and = n1 & n2;
        xor = n1 ^ n2;

        /*
         * Now we see in the first note that
         * we do use a '+' operator so we
         * in order to replace it, will have
         * to "force" the AND expression to return
         * 0 (zero), we do this in the while loop.
         */
        while (and != 0) {
            and <<= 1;
            temp = xor ^ and;
            and &= xor;
            xor = temp;
        }
        return xor;
    }

    /**
     * See 'int add(int, int) , II)I {method desc asm}'
     *
     * @param n1 integer multiplicand 'x'
     * @param n2 integer multiplier   'y'
     * @return x * y
     */
    public static int mult(int n1, int n2) {
    /*
     * No need to do any calculations in case
     * any of the integers are zero
     */
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
    /* This value will hold n1 * 2^i for varying values of i.  It will
     * start off holding n1 * 2^0 = n1, and after each iteration will
     * be updated to hold the next term in the sequence.
     */
        int a = n1;

    /* This value will be used to read the individual bits out of n2.
     * We'll use the shifting trick to read the bits and will maintain
     * the invariant that after i iterations, b is equal to n2 >> i.
     */
        int b = n2;

    /* This value will hold the sum of the terms so far. */
        int result = 0;

    /* Continuously loop over more and more bits of n2 until we've
     * consumed the last of them.  Since after i iterations of the
     * loop b = n2 >> i, this only reaches zero once we've used up
     * all the bits of the original value of n2.
     */
        while (b != 0) {
        /* Using the bitwise AND trick, determine whether the ith
         * bit of b is a zero or one.  If it's a zero, then the
         * current term in our sum is zero and we don't do anything.
         * Otherwise, then we should add n1 * 2^i.
         */
            if ((b & 01) != 0) {
            /* Recall that a = n1 * 2^i at this point, so we're adding
             * in the next term in the sum.
             */
                result = result + a;
            }

        /* To maintain that a = n1 * 2^i after i iterations, scale it
         * by a factor of two by left shifting one position.
         */
            a <<= 1;

        /* To maintain that b = n2 >> i after i iterations, shift it
         * one spot over.
         */
            b >>= 1;
        }

        return result;
    }

}