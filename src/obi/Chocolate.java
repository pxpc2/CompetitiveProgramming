package obi;

import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Chocolate
{


    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        final int x1 = s.nextInt();
        final int y1 = s.nextInt();
        final int x2 = s.nextInt();
        final int y2 = s.nextInt();

        if (Math.min(x1, x2) <= N/2 && Math.max(x1, x2) > N/2)
        {
            System.out.println("S");
            return;
        } else if (Math.min(y1, y2) <= N/2 && Math.max(y1, y2) > N/2)
        {
            System.out.println("S");
            return;
        }
        System.out.println("N");
    }

}
