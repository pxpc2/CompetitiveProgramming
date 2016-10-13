package obi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Blefe
{

    public static void main(final String... args)
    {
        final Scanner inp = new Scanner(System.in);
        final int n = inp.nextInt();
        final int m = inp.nextInt();
        String discard = inp.nextLine();
        discard = null;
        System.gc();
        final String[] aSeqS = inp.nextLine().split("\\s");
        final String[] bSeqS = inp.nextLine().split("\\s");
        final int[] aSeq = new int[n];
        final int[] bSeq = new int[m];
        for (int i = 0; i < n; i++)
        {
            aSeq[i] = Integer.valueOf(aSeqS[i]);
        }
        for (int i = 0; i < m; i++)
        {
            bSeq[i] = Integer.valueOf(bSeqS[i]);
        }
        final ArrayList<Integer> alreadyInB = new ArrayList<>();
        for (int b : bSeq)
        {
            if (!isContained(aSeq, b) && !isSum(alreadyInB, b))
            {
                System.out.print(b);
                System.exit(0);
            } else
            {
                alreadyInB.add(b);
            }
        }
        System.out.print("sim");
    }

    /**
     *
     * @param a array A
     * @param b integer to check
     * @return true if b E A, false if not
     */
    public static boolean isContained(int[] a, int b)
    {
        for (int anA : a)
        {
            if (b == anA)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @param alreadyInB list of numbers added to B
     * @param b integer to check
     * @return true if b E B, false if not
     */
    public static boolean isSum(List<Integer> alreadyInB, int b)
    {
        for (int anA : alreadyInB)
        {
            for (int anA1 : alreadyInB)
            {
                if (b == anA + anA1)
                {
                    return true;
                }
            }
        }
        return false;
    }}
