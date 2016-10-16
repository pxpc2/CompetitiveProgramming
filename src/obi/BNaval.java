package obi;

import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class BNaval
{
    private static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt(), m = s.nextInt(); //  linhas, colunas
        char[][] campo = new char[n][m];
        s.nextLine();
        for (int i = 0; i < n; i++)
        {
            final String ss = s.nextLine();
            if (ss.isEmpty()) continue;
            final char[] line = ss.toCharArray();
            System.arraycopy(line, 0, campo[i], 0, m);
        }
        final int k = s.nextInt();
        for (int i = 0; i < k; i++)
        {
            final int bomb_x = s.nextInt()-1, bomb_y = s.nextInt()-1;
            if (campo[bomb_x][bomb_y] == '#')
                campo[bomb_x][bomb_y] = '@';
        }

        int count = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (campo[i][j] == '@')
                {
                    int ok = 1;
                    for (int u = 0; u < 4; u++)
                    {
                        for (int l = 0; l < 4; l++)
                        {
                            int x = i + dx[u], y = j + dy[l];
                            if (!isIn(x,y,n,m)) continue;
                            if (campo[x][y] == '#') ok = 0;
                        }
                    }
                    System.out.println(ok + " for " + i + "; " + j);
                    count += ok;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean isIn(int x, int y, int n, int m) { return x >= 0 && y >= 0 && x < n && y < m;}
}
