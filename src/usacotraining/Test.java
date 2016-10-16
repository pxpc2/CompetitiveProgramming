package usacotraining;

import java.io.*;

/*
 ID: pedro_d1
 LANG: JAVA
 TASK: test
 */
public class Test
{

    public static void main(final String[] args)
    {
        try
        {
            final BufferedReader br = new BufferedReader(new FileReader("test.in"));
            final PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
            final char[] line = br.readLine().toCharArray();
            int sum = 0;
            for (char c : line)
            {
                try
                {
                    sum += Integer.valueOf(String.valueOf(c));
                } catch (NumberFormatException ignored)
                {
                }
            }
            p.println(sum);
            p.close();
            br.close();
        } catch (final IOException e)
        {
            e.printStackTrace();
        }
    }

}
