package obi;

import java.util.*;


/**
 * @author Pedro Daia
 */
public class Reuniao
{

    public static final int INFINITY = 999999999;

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt(), m = s.nextInt(); // #cidades, #estradas_q_as_interligam
        final int[][] adj = new int[n][n], dist = new int[n][n];
       // System.out.println("N: " + n);
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                adj[i][j] = INFINITY;
            }
        }
        for (int  i = 0; i < m; i++)
        {
            final int u = s.nextInt(), v = s.nextInt(), w = s.nextInt();
            adj[u][v] = w;
            adj[v][u] = w;
        }
        s.close();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                dist[i][j] = adj[i][j];
                dist[j][i] = dist[i][j];
            }
        }

        for (int i =0; i < n; i++)
        {
            for (int j =0; i < n; i++)
            {
                for (int k =0; i < n; i++)
                {
                    dist[j][k] = Math.min(dist[j][k], dist[i][j] + dist[i][k]);
                }
            }
        }

        for (int i =0; i < n; i++)
            dist[i][i] = 0;

        int menor = INFINITY;
        for (int i =0 ; i < n; i++)
        {
            int curr = -1;

            for (int j = 0; j < n; j++)
            {
                curr = Math.max(curr, dist[i][j]);
            }

            if (curr < menor)
                menor = curr;

        }
        System.out.print(menor);

        /*List<Integer> maxes = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
           // System.out.print(1);
            final int[] distances = getDistancesFrom(i, adj);
           // System.out.print(2);
            final ArrayList<Integer> list = new ArrayList<>(n);
            for (int k = 0; k < n; k++)
                list.add(distances[k]);
            final int curr = Collections.max(list);
            maxes.add(curr);
        }

        System.out.print(Collections.min(maxes));
        */
    }

    public static int[] getDistancesFrom(final int source,
                                  final int[][] adj)
    {
        final int n = adj.length;
        final boolean[] processed = new boolean[n];
        final int distance[] = new int[n];

        for (int i= 0; i < n; i++)
            distance[i] = adj[source][i];

        distance[source] = 0;
        processed[source] = true;

        while (true)
        {
            int curr = -1;
            int min = INFINITY;

            for (int  i = 0; i < n; i++)
            {
                //System.out.println("source: " + source + " - i: " + i + "  - distance: " + distance[i]);
                if (!processed[i] && distance[i] < min)
                {
                    curr = i;
                    min = distance[i];
                }
            }

            if (curr == -1)
                break;

            processed[curr] = true;
            for (int j = 0; j < n; j++)
                distance[j] = Math.min(distance[j], distance[curr] + adj[curr][j]);
        }

        return distance;
    }



}
