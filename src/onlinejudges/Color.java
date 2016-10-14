package onlinejudges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class Color
{

    static int[][] mapa;
    static int[] componente;

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // linhas
        int m = s.nextInt(); // colunas
        int x = s.nextInt(); // coordenada nas linhas
        int y = s.nextInt(); // coordenada nas colunas
        int k = s.nextInt(); // numero de quadrados cheios
        mapa = new int[n][m];

        for (int i = 0; i < k; i++)
        {
            mapa[s.nextInt()][s.nextInt()] = 1; // preenchido
        }
    }

    private void dfs(int vx, int vy)
    {

    }

}
