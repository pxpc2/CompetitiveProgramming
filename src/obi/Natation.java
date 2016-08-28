package obi;

import java.util.Scanner;

public class Natation
{

    public static void main(final String[] args)
    {

        final Scanner s = new Scanner(System.in);
        String ss = s.nextLine();
        String[] sss = ss.split("\\s");

        String max = "1000000";
        double maxx = 0;

        for (String a : sss)
        {
            double d = Double.valueOf(a);
            maxx = Double.valueOf(max);
            System.out.print(d);
            if (d < maxx)
                maxx = d;
            if (a.equals(maxx))
            {
                System.out.print("Empate");
                return;
            }
        }

        if (maxx == Double.valueOf(sss[0]))
        {
            System.out.print("O");
        }

        if (maxx == Double.valueOf(sss[1]))
        {
            System.out.print("B");
        }

        if (maxx == Double.valueOf(sss[2]))
        {
            System.out.print("I");
        }


    }

}
