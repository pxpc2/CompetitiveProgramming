package algorithms;

/**
 * @author Pedro Daia
 */
public class Dijkstra
{

    public static final int INFINITY = 99999999;

    /**
     * first gotta set the respective distance values between those vertices who are
     * connected by an edge. The dist from i to j, if they're not connected by an edge,
     * shall be infinity.
     *
     * @param source
     * @param dist
     */
    public static void dijkstra(final int source,
                                 final int[][] dist)
    {
        final boolean[] processed = new boolean[dist.length];
        final int[] distance = new int[dist.length];

        distance[source] = 0;
        processed[source] = true;
        System.arraycopy(dist[source], 0, distance, 0, dist.length);

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
                // distance[i] should be infinity if i has no edge to source
                // then, since we're looking at the current vertex, we update the
                // distance to the distance to go from source to current and then
                // the distance to go from current to i, this way we can know if
                // we should go back to a higher cost move than the one to curr
                // but that will result in a lower cost total move then if we moved
                // to curr.
            }
        }
    }

}
