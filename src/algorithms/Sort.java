package algorithms;

/**
 * @author Pedro Daia
 */
public class Sort
{

    /**
     * Linha i tem 2^i vetores de tamanho N/2^i cada, assim cada linha roda 2^i operações de
     * O(N/2^i), tendo assim O(2^i * N/2^i) = O(N) para cada linha.
     * Seja m o #linhas, então 2^m = N => m log2(2) = log2(N) => m = log2(N)
     * => O(N * log2(N)), assim a complexidade é O(N logN) C.Q.D.
     *
     * @param left ~metade do vetor total
     * @param right ~metade do vetor total
     * @param result união ordenada de ambas metades
     */
    private static int[] merge(int[] left, int[] right, int[] result)
    {
        int l = 0, r = 0, k = 0; // indexes for each array
        while (l < left.length && r < right.length)
        {
            if (left[k] <= right[k])
            {
                result[k] = left[k];
                l++;
            }
            else
            {
                result[k] = right[k];
                r++;
            }
            k++;
            // check the remaining, which is actually the one
            // that had the biggest values from the start
            while (l < left.length)
            {
                result[k] = left[l];
                l++;
                k++;
            }
            while (r < right.length)
            {
                result[k] = right[r];
                r++;
                k++;
            }
        }
        return result;
    }

    /**
     * @param list vetor para ordenar
     * @return o vetor ordenado
     */
    private static int[] mergeSort(int[] list)
    {
        if (list.length < 2)
        {
            return list;
        }

        final int n = list.length;
        int[] left = new int[(int) Math.floor(n/2)];
        int[] right = new int[n - left.length];
        System.arraycopy(list, 0, left, 0, left.length);
        System.arraycopy(list, left.length, right, 0, n - left.length);

        mergeSort(left); // will separate in half until we get a list < 2
        mergeSort(right); // then this will run and do the same
        merge(left, right, list); // then in a FILO order we order and merge the halves

        return list;
    }


}