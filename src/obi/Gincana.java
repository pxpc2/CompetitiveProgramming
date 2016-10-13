package obi;

import java.util.Scanner;

/**
 * @author Pedro Daia
<<<<<<< HEAD
 * OlimpÃ­ada Brasileira de InformÃ¡tica
=======
 * Olimpíada Brasileira de Informática
>>>>>>> origin/master
 */
public class Gincana
{

    private static int n, m;
    private static int[][] arestas;
    private static int[] componente;
    private static int qt = 0;

    public static void main(String[] args)
    {
        final Scanner s = new Scanner(System.in);
<<<<<<< HEAD
        n = s.nextInt(); // nÃºmero de alunos
=======
        n = s.nextInt(); // número de alunos
>>>>>>> origin/master
        m = s.nextInt(); // pares de amizades
        arestas = new int[n][n]; // 1 se amigo
        componente = new int[n];
        for (int i=0;i < m; i++)
        {
            final int a = s.nextInt() - 1;
            final int b = s.nextInt() - 1;
            arestas[a][b] = 1;
            arestas[b][a] = 1;
        }
        for (int i = 0; i < n; i++)
        {
            if (componente[i] == 0)
            {
                qt++;
                componente[i] = qt;
                dfs(i);
            }
        }
        System.out.print(qt);
    }


    private static void dfs(final int inicial)
    {
        for (int i=0;i < n; i++)
        {
            final int index = arestas[inicial][i];
            if (index == 1)
            {
                if (componente[i] == 0)
                {
                    componente[i] = componente[inicial];
                    dfs(i);
                }
            }
        }
    }


<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
