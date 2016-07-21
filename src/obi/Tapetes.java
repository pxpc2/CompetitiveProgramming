package obi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
/**
 * @author Pedro Daia
 */
public class Tapetes
{
    public static void main(final String... args)
    {
        final Scanner in = new Scanner(System.in);
        final String[] bleh = in.nextLine().split("\\s");
        final int L = Integer.valueOf(bleh[0]); // comprimento do tubo
        final int N = Integer.valueOf(bleh[1]); // quantidade de tapetes

        BigInteger l = BigInteger.valueOf((N - 1) + (L-N+1)*(L-N+1));
        System.out.print((l.intValue() < 0 ? BigDecimal.valueOf(N-1 + Math.pow(L-N+1, 2)) : l.intValue()));
    }

}
