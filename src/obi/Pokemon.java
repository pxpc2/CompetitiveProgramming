package obi;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon
{

    private static final ArrayList<String> POKEMONS = new ArrayList<>();

    public static void main(final String[] args)
    {

        int count = 0;

        final Scanner s = new Scanner(System.in);
        int caught = s.nextInt();
        final String discard = s.nextLine();

        for (int i = 0; i < caught; i++)
        {
            final String l = s.nextLine();
            if (!has(l))
            {
                POKEMONS.add(l);
                count++;
            }
        }

        System.out.println("Falta(m) " + (151-count)  + " pomekon(s).");

    }

    public static boolean has(final String  s)
    {
        for (String a : POKEMONS)
        {
            if (s.equals(a))
                return true;
        }
        return false;
    }

}
