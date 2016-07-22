package algorithms;

/**
 * @author Pedro Daia
 */
public class Search
{

    public static int binarySearch(final int[] array, final int v)
    {
        final int n = array.length;
        int init = 0, end = n, meio = (int)Math.floor(n/2);
        while (init <= end)
        {
            if (array[meio] == v)
                return meio;
            else if (array[meio] < v)
                init = meio + 1;
            else if (array[meio] > v)
                end = meio - 1;
        }
        return -1;
    }

}
