package algorithms;

/**
 * @author Pedro Daia
 */
public class FloodFill
{

    public static final int INFINITY = 99999999;

    public static void dijkstra(final int source,
                                 final int[][] dist)
    {
        final boolean[] processed = new boolean[dist.length];
        final int[] distance = new int[dist.length];

        distance[source] = 0;
        processed[source] = true;

        while (true)
        {
            int curr = -1;
            int min = INFINITY;
            for (int i = 0; i < dist.length; i++)
            {
                if (!processed[i] && distance[i] < min)
                {
                    curr = i;
                    min = distance[i];
                }
            }
            if (curr == -1) break;
            processed[curr] = true;

            // update distances
            for (int i = 0; i < dist.length; i++)
            {
                // set distance from source to i as whichever is smallest,
                // the current distance from source to i or the current distance
                // from the current closest vertex plus the distance from this
                // current vertex to i
                distance[i] = Math.min(distance[i], distance[curr] + dist[curr][i]);
            }
        }
    }

}
