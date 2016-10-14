package onlinejudges;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * http://br.spoj.com/problems/TROIA13.pdf
 *
 * @author Pedro Daia
 */
public class FamiliasTroia
{



    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] componente = new int[n];
        for (int i = 0; i < n; i++)
            componente[i] = -1;
        ArrayList[] l = new ArrayList[n];
        for (int i = 0; i < m; i++)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            // adicionar às listas de adjacências
            l[a].add(b);
            l[b].add(a);
        }

        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (componente[i] == -1)
            {
                // começar uma família
                count++;
                componente[i] = count;
                dfs(i, l[i], componente);
            }
        }

        System.out.println(count);

    }

    private static void dfs(int v, ArrayList l, int[] comps)
    {
        for (int i = 0; i < l.size(); i++)
        {
            int a = (Integer) l.get(i);
            if (comps[a] == -1)
            {
                comps[a] = comps[v];
                dfs(a, l, comps);
            }
        }
    }

}
