package obi.segundafase;

import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Jardim
{

    private static int[] x, y;

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        x = new int[7];
        y = new int[7];
        for (int i = 0; i < 7; i++)
        {
            x[i] = s.nextInt();
            y[i] = s.nextInt();
        }

        setEixoPos();

        // p2p3 sempre paralelos ao eixo x e colineares com p2,p3,p4,p5
        int yParalel = y[1];
        for (int i = 1; i < 5; i++)
        {
            if (y[i] != yParalel)
            {
                System.out.println("N");
                return;
            }
        }

        /*for (int i = 0; i < 7; i++)
        {
            System.out.print("X(p"+(i+1)+") = " + x[i]);
            System.out.println("    Y(p"+(i+1)+") = " + y[i]);
        }*/

        /*
        comprimento de p1 ao p2:
        sqrt[(|x1-x2|)ˆ2 + (|y1-y2|)ˆ2]
         */
        checkSizeOne();
        //checkMedOne();
        checkDifSize();
        checkSizeTwo();
        System.out.println("S");
    }

    private static void checkSizeOne()
    {
        int a = (x[0] > x[1] ? x[0] - x[1] : x[1] - x[0]);
        int b = (y[0] > y[1] ? y[0] - y[1] : y[1] - y[0]);

        int c = (x[0] > x[2] ? x[0] - x[2] : x[2] - x[0]);
        int d = (y[0] > y[2] ? y[0] - y[2] : y[2] - y[0]);

        int e = a*a + b*b, f = c*c + d*d;
        if (e != f)
        {
            System.out.println("N");
            System.exit(0);
        }
    }

    private static void checkMedOne()
    {
        int a = (x[1] > x[2] ? x[1] - x[2] : x[2] - x[1]);
        int b = (x[3] > x[4] ? x[3] - x[4] : x[4] - x[3]);
        if (a/2 != b/2)
        {
            System.out.println("N");
            System.exit(0);
        }
    }

    private static void checkDifSize()
    {
        int a = (x[1] > x[2]? x[1] - x[2] : x[2] - x[1]);
        int b = (x[3] > x[4]? x[3] - x[4] : x[4] - x[3]);
        if (a < b)
        {
            System.out.println("N");
            System.exit(0);
        }
    }

    private static void intercept()
    {
        int ox = x[0];
        int sx = x[5];
        if (ox > sx)
        {

        }
    }

    private static void checkSizeTwo()
    {
        int c = (y[3] > y[5]? y[3] - y[5] : y[5] - y[3]);
        int d  = (y[4] > y[6]? y[4] - y[6] : y[6] - y[4]);

        //int e = a*a + b*b, f = c*c + d*d;
        if (c != d)
        {
            System.out.println("N");
            System.exit(0);
        }
    }


    private static void setEixoPos()
    {
        int minx = 1111111111, miny = 1111111111;
        for (int i : x)
        {
            if (i <= minx)
                minx = i;
        }
        for (int i : y)
        {
            if (i <= miny)
                miny = i;
        }
        // ponto zero ta em (minx, miny)

        for (int i = 0; i < x.length; i++)
        {
            if (x[i] <= 0)
            {
                x[i] = (minx - x[i])*-1;
            }
            else
            {
                x[i] = x[i] - minx;
            }

            if (y[i] <= 0)
            {
                y[i] = (miny - y[i])*-1;
            }
            else
            {
                y[i] = y[i] - miny;
            }
        }
    }

}