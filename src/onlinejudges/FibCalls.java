package onlinejudges;

import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class FibCalls
{

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        int k =s.nextInt();
        int a =1;
        if (k > 12) return;
        for (int i = k; i > 1; i--)
        {
            a *= i;
        }
        System.out.println(a);
    }


    static int fatorial(int n )
    {
        if (n == 1) return n;
        return n*fatorial(n-1);

    }

}
