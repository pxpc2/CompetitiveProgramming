package algorithms;

public class Dijkstra
{

    public static final int INFINITY = 999999999;


    /**
     * sets the lowest distance (the fastest path in the graph)
     * from vertex source to all other vertices.
     *
     * @param source the source vertex
     * @param adj the adjacency list
     * @return the distances from vertex source to each vertex
     */
    public static int[] getDistances(final int source,
                                    final int[][] adj)
    {
        final int n = adj.length;
        final boolean[] processed = new boolean[n];
        final int[] distance = new int[n];
        System.arraycopy(adj[source], 0, distance, 0, n);

        distance[source] = 0;
        processed[source] = true;

        // "infinite" loop so we can loop until we find no more nodes to process
        // that is, all nodes are processed or all nodes with a path (a convex component)
        while (true)
        {
            int min  = INFINITY;
            int curr = -1;

            for (int  i= 0; i <n ; i++)
            {
                if (!processed[i] && distance[i] < min)
                {
                    curr = i;
                    min = distance[i];
                }
            }

            if (curr == -1)
                break; // the base case, see the comment above the loop

            processed[curr] = true;

            // updates distances of the vertices connected by an edge to current vertex
            for (int  i=0; i < n; i++)
                distance[i] = Math.min(distance[i], distance[curr] + adj[curr][i]);
        }

        return distance;
    }

}
