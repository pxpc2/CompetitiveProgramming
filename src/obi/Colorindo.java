package obi;

import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Colorindo
{
    // par ordenado = (linha, coluna)
    // #linhas(vertical), #colunas(horizontal), linha init, coluna init, #cheios RESPECTIVAMENTE
    private static int n,m,x,y,k;

    private static int[][] matriz, visited; // 1 se cheio, 0 se vazio

    private static int[] vx = {0, 1, 0, -1, 1, -1};
    private static int[] vy = {1, 0, -1, 0, 1, -1};

    private static int qt = 0;

    public static void main(final String... args)
    {
        final Scanner s = new Scanner(System.in);
        n = s.nextInt(); m = s.nextInt();
        x = s.nextInt()-1; y = s.nextInt()-1;
        k = s.nextInt();
        matriz = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < k; i++)
        {
            matriz[s.nextInt()-1][s.nextInt()-1] = 1;
        }
        dfs(x, y);
        System.out.print(qt);
    }

    private static void dfs(int q, int j)
    {
        if (n*m - qt == k) return;
        if (matriz[q][j] == 1) return;
        qt++;
        matriz[q][j] = 1;
        visited[q][j] = 1;
        for (int i = 0; i < 6; i++)
        {
            int qq = q + vx[i];
            int jj = j + vy[i];
            if (qq < n && jj < m && qq >= 0 && jj >= 0)
            {
                if (visited[qq][jj] == 0)
                {
                    dfs(qq, jj);
                }
            }
        }
    }


}