package onlinejudges;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * http://br.spoj.com/problems/TARZAN12.pdf
 *
 * @author Pedro Daia
 */
public class Tarzan
{


    static Tree[] trees;

    public static void main(final String[] args)
    {
        final Scanner s = new Scanner(System.in);
        final int rem = s.nextInt();
        final int D = s.nextInt();
        trees = new Tree[rem];
        for (int i = 0; i < rem; i++)
        {
            trees[i] = new Tree();
            trees[i].neighbours = new ArrayList<>();
            trees[i].checked = new ArrayList<>();
            trees[i].checked.add(trees[i]);
            trees[i].x = s.nextInt();
            trees[i].y = s.nextInt();
        }
        for (Tree t : trees)
        {
            for (Tree tt : trees)
            {
                if (!t.checked.contains(tt))
                {
                    if (t.dist(tt) <= D)
                    {
                        t.neighbours.add(tt);
                        tt.neighbours.add(t);
                    }
                    t.checked.add(tt);
                    tt.checked.add(t);
                }
            }
        }
        int count = 0;
        for (Tree tree : trees)
        {
            if (count > 1)
            {
                // o grafo não é conexo
                System.out.println("N");
                return;
            }
            if (tree.component == -1)
            {
                count++;
                tree.component = count;
                dfs(tree);
            }
        }
        System.out.println("S");
    }

    private static void dfs(Tree a)
    {
        for (int i = 0; i < a.neighbours.size(); i++)
        {
            Tree b = a.neighbours.get(i);
            if (b.component == -1)
            {
                b.component = a.component;
                dfs(b);
            }
        }
    }

    private static class Tree
    {
        int x = -1, y = -1;
        ArrayList<Tree> checked;
        ArrayList<Tree> neighbours;
        int component = -1;

        double dist(Tree t)
        {
            return Math.sqrt(Math.pow(x-t.x, 2) + Math.pow((y-t.y), 2));
        }

    }

}
