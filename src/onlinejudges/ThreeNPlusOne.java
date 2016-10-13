package onlinejudges;

import java.util.Scanner;

/**
 *
 * https://uva.onlinejudge.org/external/1/100.pdf
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=36
 *
 * @author Pedro Daia
 */
public class ThreeNPlusOne
{

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int max = 0;
        for (int i = k; i > n; i--)
        {
            three(i);
            if (count > max)
                max = count;
            count = 0;
        }
        System.out.println(n + " " + k + " " + max);
    }

    static int count = 0;

    private static int three(final int n)
    {
        count++;
        if (n == 1) return 1;
        if (n % 2 == 0) return three(n / 2);
        return three((3 * n) + 1);
    }

}
