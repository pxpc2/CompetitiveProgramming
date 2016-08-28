package obi.segundafase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Pokemon
{

    public static void main(final String args[])
    {
        final Scanner s = new Scanner(System.in);

        int numdoces = s.nextInt();
        final int x = s.nextInt();
        final int y = s.nextInt();
        final int z = s.nextInt();

        int[] aa = new int[3];
        aa[0] = x; aa[1] = y; aa[2] = z;

        ArrayList<Integer> one = new ArrayList<>();
        for (int i : aa)
            one.add(i);

        ArrayList<Integer> sorted = sort(one);


        int count = 0;
        for (Integer aSorted : sorted)
        {
            int a = numdoces - aSorted;
            if (a >= 0)
            {
                numdoces = a;
                count++;
            }
        }

        System.out.println(count);

    }

    private static ArrayList<Integer> sort(ArrayList<Integer> arr)
    {
        ArrayList<Integer> l = new ArrayList<>();
        int min = 11111111;


        int ind = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) <= min)
            {
                min = arr.get(i);
                ind = i;
            }
        }
        l.add(arr.get(ind));
        arr.remove(ind);
        min = 111111;
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) <= min)
            {
                ind = i;
                min = arr.get(i);
            }
        }
        l.add(arr.get(ind));
        arr.remove(ind);
        l.addAll(arr);

        return l;
    }

}