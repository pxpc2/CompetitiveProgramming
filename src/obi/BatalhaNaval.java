package obi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pedro Daia
 */
public class BatalhaNaval
{

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt(), m = s.nextInt(); //  linhas, colunas
        s.nextLine();
        final char[][] matriz = new char[n][m];
        final ArrayList<ShipPart> shipParts = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            final String ss = s.nextLine();
            if (ss.isEmpty())continue;
            final char[] line = ss.toCharArray();
            for (int j = 0; j < m; j++)
            {
                matriz[i][j] = line[j];
                if (matriz[i][j] == '#')
                {
                    final ShipPart p = new ShipPart();
                    p.x = i;
                    p.y = j;
                    shipParts.add(p);
                }
            }
            for (final ShipPart p : shipParts)
            {
                p.visited = true;
                setNeighbours(p, shipParts, matriz, n, m);
                System.out.println("Ship on [" + (p.x+1) + "; " + (p.y+1) + "] is together with ");
                for (ShipPart a : p.neighbours)
                    System.out.println("["+(a.x+1)+"; "+(a.y+1)+"]");
            }
        }
        final int k = s.nextInt();
        for (int i = 0; i < k; i++)
        {
            final int bomb_x = s.nextInt()-1, bomb_y = s.nextInt()-1;
            if (matriz[bomb_x][bomb_y] == '#')
            {
                final ShipPart hit = getAt(bomb_x, bomb_y, shipParts);
                assert hit != null;
                hit.sinked = true;
            }
        }
    }

    private static ShipPart getAt(final int x, final int y,
                                  final ArrayList<ShipPart> l)
    {
        for (final ShipPart p : l)
        {
            if (p.x == x && p.y == y)
                return p;
        }
        return null;
    }

    // ta bugando
    private static void setNeighbours(final ShipPart p, final ArrayList<ShipPart> ships,
                                      final char[][] c,
                                      final int n, final int m)
    {
        final int[] vx = {0, 1, 0, -1}, vy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++)
        {
            final int xx = p.x + vx[i], yy = p.y + vy[i];

            if (xx < n && yy < m && xx >= 0 && yy >= 0)
            {
                if (c[xx][yy] == '#')
                {
                    final ShipPart pp = getAt(xx, yy, ships);
                    assert pp != null;
                    if (pp.visited) continue;
                    if (!p.neighbours.contains(pp))
                        p.neighbours.add(pp);
                    if (!pp.neighbours.contains(p))
                        pp.neighbours.add(p);
                    pp.visited = true;
                }
            }
        }
    }

    private static class ShipPart
    {
        ShipPart()
        {
            neighbours = new ArrayList<>();
        }
        int x, y;
        int index = -1;
        boolean sinked = false;
        boolean visited = false;
        ArrayList<ShipPart> neighbours;
    }

}
