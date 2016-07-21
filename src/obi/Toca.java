package obi;

import java.util.*;

/**
 * @author Pedro
 */
public class Toca
{
    private static int n, m, x, y, xf, yf;
    private static int[] vx = {0, 1, 0, -1},  vy = {1, 0, -1, 0};
    private static int[][] sala, dist;

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        sala = new int[n][m];
        dist = new int[n][m];

        for (int nn = 0; nn < n; nn++)
        {
            for (int mm = 0; mm < m; mm++)
            {
                sala[nn][mm] = s.nextInt();
                if (sala[nn][mm] == 2)
                {
                    x= nn;
                    y = mm;
                    dist[x][y] = 1;
                }
                // set all vertices to -1 (but the initial vertex)
                else if (sala[nn][mm] == 3)
                {
                    xf = nn;
                    yf = mm;
                    dist[nn][mm] = -1;
                }
                else
                {
                    dist[nn][mm] = -1;
                }
            }
        }
        dfs(x, y);
        System.out.print(dist[xf][yf]);
    }

    /**
     *
     * @param x init coord x
     * @param y init coord y
     */
    private static void dfs(int x, int y)
    {
        for (int k = 0; k < 4; k++)
        {
            int xx = x + vx[k];
            int yy = y + vy[k];
            if (xx < n && yy < m)
            {
                if (xx >= 0 && yy >= 0) // thank you debugging
                {
                    if (dist[xx][yy] < 0 && sala[xx][yy] > 0)
                    {
                        dist[xx][yy] = dist[x][y] + 1;
                        dfs(xx, yy);
                    }
                }
            }
        }
    }

    /*private static void bfs(int x, int y)
    {
        LinkedList<Integer> qX = new LinkedList<>(); // add last, remove first for FIFO
        LinkedList<Integer> qY = new LinkedList<>();
        qX.addFirst(x);
        qY.addFirst(y);
        while (!qX.isEmpty() && !qY.isEmpty())
        {
            int xx = qX.removeFirst();
            int yy = qY.removeFirst();
            for (int k = 0; k < 4; k++)
            {
                int adjX = xx + vx[k];
                int adjY = yy + vy[k];
                if (xx < n && yy < m)
                {
                    if (dist[adjX][adjY] < 0 && sala[adjX][adjY] > 0)
                    {
                        dist[adjX][adjY] = dist[xx][yy] + 1;
                        qX.addLast(x);
                        qY.addLast(y);
                    }
                }
            }
        }
    }*/

}
