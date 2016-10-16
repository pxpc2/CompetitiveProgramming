package obi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class BBNaval
{
    private static ArrayList<Piece> pieces = new ArrayList<>();
    private static char[][] campo;
    private static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt(), m = s.nextInt();
        campo = new char[n][m];
        s.nextLine();
        for (int i = 0; i < n; i++)
        {
            final String line = s.nextLine();
            if (line.isEmpty()) continue;
            final char[] c = line.toCharArray();
            for (int j = 0; j < m; j++)
            {
                campo[i][j] = c[j];
                final Piece p = new Piece();
                p.neighbours = new char[n][m];
                p.x = i;
                p.y = j;
                p.symbol = c[j];
                if (c[j] == '#')
                    pieces.add(p);
            }
        }
        final int k = s.nextInt();
        for (int i = 0; i < k; i++)
        {
            final int bomb_x = s.nextInt()-1, bomb_y = s.nextInt()-1;
            //System.out.println("checking " + bomb_x + "; "+bomb_y);
            replaceWith(bomb_x, bomb_y, '#', '@'); // @ = hit
        }
    }
    private static void replaceWith(int x, int y, char old, char new_)
    {
        for (Piece p : pieces)
        {
            if (p.x == x && p.y == y && p.symbol == old)
            {
                Piece p_ = new Piece();
                p_.x = x;
                p_.y = y;
                p_.symbol = new_;
                pieces.remove(p);
                pieces.add(p_);
                return;
            }
        }
    }
    private static class Piece
    {
        int x, y, index;
        char symbol;
        char[][] neighbours;
    }

}
