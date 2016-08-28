package obi.segundafase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Primo
{

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        int n = s.nextInt(); int k = s.nextInt();
        int[] primos = new int[k];

        for (int i = 0; i < k; i++)
            primos[i] = s.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();
        for (int a : primos)
        {
            lista.add(a);
        }

        ArrayList<Integer> shouldnt = new ArrayList<>();

        for (int i = n; i > 0; i--)
        {
            if (!shouldnt.contains(i))
            {
                //if (i == 4)
                //  System.out.println("passei");
                for (int p : lista)
                {
                    int sqrt = (int)Math.sqrt(i);
                    if (sqrt*sqrt == i && sqrt >= p)
                    {
                        //System.out.println("sqrt of " +i);
                        if ((sqrt % p) == 0)
                        {
                            shouldnt.add(sqrt);
                            shouldnt.add(i);
                            continue;
                        }
                    }
                    if ((i % p) == 0)
                    {
                        //System.out.println("i: " + i + " e p: " + p);
                        shouldnt.add(i);
                        break;
                    }
                }
            }
        }

        System.out.println(n - shouldnt.size());

    }

}