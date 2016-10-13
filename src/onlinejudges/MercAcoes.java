package onlinejudges;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * http://br.spoj.com/problems/ACOES1MG.pdf
 *
 * @author Pedro Daia
 */
public class MercAcoes
{

    static final ArrayList<Integer> l = new ArrayList<>();
    static final ArrayList<Integer> ens = new ArrayList<>();
    static final ArrayList<Integer> kays = new ArrayList<>();


    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        while (true)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            if (n == 0 && k == 0) break;
            ens.add(n);
            kays.add(k);
        }
        for (int i = 0; i < ens.size(); i++)
        {
            split(ens.get(i), kays.get(i));
            System.out.println(l.size());
            l.clear();
        }
    }

    static void split(int n, int k)
    {
        if (n <= k)
        {
            l.add(n);
        }
        else
        {
            int a = (int) Math.floor(n / 2);
            split(a, k);
            split(n-a, k);
        }
    }

}
