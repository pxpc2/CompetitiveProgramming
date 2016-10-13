package onlinejudges;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * http://br.spoj.com/problems/F91.pdf
 *
 * @author Pedro Daia
 */
public class FNinetyOne
{
    static ArrayList<Integer> l = new ArrayList<>();


    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        while (true)
        {
            int k = s.nextInt();
            if (k == 0) break;
            else
                l.add(k);
        }
        for (int i : l)
        {
            System.out.println("f91("+i+") = " + f(i));
        }
    }

    static int f(int a)
    {
        if (a <= 100)
            return f(f(a+11));
        else
            return a - 10;
    }

}
