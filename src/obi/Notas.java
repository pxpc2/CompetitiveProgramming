package obi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Questao 01 OBI 2014 2a fase
 *
 * @author Pedro Daia
 */
public class Notas
{

    public static void main(String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        String discard = s.nextLine();
        final String[] stringArray = s.nextLine().split("\\s");
        s.close();

        discard = null;
        System.gc();

        final int[] notas = new int[n];
        for (int i = 0; i < n; i++) {
            notas[i] = Integer.valueOf(stringArray[i]);
        }

        List<Integer> l = getBestGrades(notas);
        int max = 0;
        for (int i : l)
        {
            if (i > max)
            {
                max = i;
            }
        }

        System.out.print(max);

    }

    public static List<Integer> getBestGrades(int[] grades)
    {
        final List<Integer> list = new ArrayList<>();
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int curr : grades)
        {
            int times = 0;
            for (int grade : grades)
            {
                if (grade == curr)
                {
                    times++;
                }
            }
            map.put(curr, times);
        }
        int max = map.get(grades[0]);
        for (int grade : grades)
        {
            final int value = map.get(grade);
            if (value > max)
            {
                max = value;
            }
        }
        for (int value : map.keySet())
        {
            if (map.get(value) == max)
            {
                list.add(value);
            }
        }
        return list;
    }


<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
