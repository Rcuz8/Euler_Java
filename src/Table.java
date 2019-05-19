import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Table<E> {
    static void prr(Object o) {System.out.print(o);}
    static void pr(Object o) {System.out.println(o);}
    static void pr(int o) {System.out.println(o);}
    static void pr(double o) {System.out.println(o);}
    static void prArr(ArrayList a) {
        if (a == null) {
            pr("null");
            return;
        }
        System.out.print("\n[ ");
        for (Object o:a) {
            System.out.print(o  + " ");
        }
        System.out.print("]\n");
    }
    static void prArr(LinkedList a) {
        if (a == null) {
            pr("null");
            return;
        }
        System.out.print("\n[ ");
        for (Object o:a) {
            System.out.print(o  + " ");
        }
        System.out.print("]\n");
    }

    private LinkedList<LinkedList<Number>> lol;  // list of lists

    public Table(int height) {
        lol = new LinkedList<>();
        for (int i = 0; i < height; i++)
            lol.add( new LinkedList<Number>());
    }

    /**
     * parse from file
     * @param filename
     */
    public Table(String filename) {
        lol = new LinkedList<>();
        File f = new File(filename);
        try {
            Scanner rdr = new Scanner(f);
            int i = 0;
            while (rdr.hasNextLine()) {
                lol.add( new LinkedList<Number>());
                String[] tkns = tokenize(rdr.nextLine());
                for (int j = 0; j < tkns.length; j++) {
                    long num = Long.valueOf(tkns[j]);
                    set(i,j,num);
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Ahhhhhh");
        }
    }

    String[] tokenize(String s) {
        return s.split(" ");
    }

    public void set(int i, int j, Number data) {
        if (lol.size() <= i)
            return; // check height
        if (lol.get(i).size() < j)
            return; // check width
        if (j == lol.get(i).size())
            lol.get(i).add(data);
        else
            lol.get(i).set(j, data);
    }

    public Number get(int i, int j) {
        if (i < 0 || j < 0) return null;
        if (lol.size() <= i) return null; // check height
        if (lol.get(i).size() <= j) return null; // check width
        return lol.get(i).get(j);
    }

    public LinkedList<LinkedList<Number>> getLol() {
        return lol;
    }

    public LinkedList<Number> diag_from(Number root, Number next_1, Number next_2, Number next_3) {
        LinkedList<Number> es = new LinkedList<>();
        es.add(root);es.add(next_1);es.add(next_2);es.add(next_3);
        return es;
    }

    public static boolean exists(Object o) { return o != null; }

    // Get bingo-like diagonals ( ROTATNumberS FROM P(i,j) )

    public LinkedList<Number> down_diagonal(int i, int j) {
        Number root    = get(i,j);
        Number next_1  = get(i+1,j);
        Number next_2  = get(i+2,j);
        Number next_3  = get(i+3,j);
        if (exists(root) && exists(next_1) && exists(next_2) && exists(next_3))
            return diag_from(root,next_1,next_2,next_3);
        return null;
    }

    public LinkedList<Number> downLeft_diagonal(int i, int j) {
        Number root    = get(i,j);
        Number next_1  = get(i+1,j-1);
        Number next_2  = get(i+2,j-2);
        Number next_3  = get(i+3,j-3);
        if (exists(root) && exists(next_1) && exists(next_2) && exists(next_3))
            return diag_from(root,next_1,next_2,next_3);
        return null;
    }

    public LinkedList<Number> downRight_diagonal(int i, int j) {
        Number root    = get(i,j);
        Number next_1  = get(i+1,j+1);
        Number next_2  = get(i+2,j+2);
        Number next_3  = get(i+3,j+3);
        if (exists(root) && exists(next_1) && exists(next_2) && exists(next_3))
            return diag_from(root,next_1,next_2,next_3);
        return null;
    }

    public LinkedList<Number> right_diagonal(int i, int j) {
        Number root    = get(i,j);
        Number next_1  = get(i,j+1);
        Number next_2  = get(i,j+2);
        Number next_3  = get(i,j+3);
        if (exists(root) && exists(next_1) && exists(next_2) && exists(next_3))
            return diag_from(root,next_1,next_2,next_3);
        return null;
    }

    long product_list(LinkedList<Number> list) {
        if (list == null) return 0;
        long product = 1;
        for (Number n: list) {
            product *= n.longValue();
        }
        return product;
    }


    public LinkedList<Number> largest_diagonal_forPoint(int i, int j) {
        LinkedList<Number> down_diagonal = down_diagonal(i,j);
        LinkedList<Number> downRight_diagonal = downRight_diagonal(i,j);
        LinkedList<Number> downLeft_diagonal = downLeft_diagonal(i,j);
        LinkedList<Number> right_diagonal = right_diagonal(i,j);
        long max = 0;
        LinkedList<Number> highest = null;
        long down = product_list(down_diagonal); if (down > max) { max=down;highest = down_diagonal; }
        long dr = product_list(downRight_diagonal); if (dr > max) { max=dr;highest = downRight_diagonal; }
        long dl = product_list(downLeft_diagonal); if (dl > max) { max=dl;highest = downLeft_diagonal; }
        long r = product_list(right_diagonal); if (r > max) { max=r;highest = right_diagonal; }

        return highest;
    }

    public long product_largest_diagonal_forPoint(int i, int j) {
        LinkedList<Number> down_diagonal = down_diagonal(i,j);
        LinkedList<Number> downRight_diagonal = downRight_diagonal(i,j);
        LinkedList<Number> downLeft_diagonal = downLeft_diagonal(i,j);
        LinkedList<Number> right_diagonal = right_diagonal(i,j);
        long max = 0;
        LinkedList<Number> highest = null;
        long down = product_list(down_diagonal); if (down > max) { max=down;highest = down_diagonal; }
        long dr = product_list(downRight_diagonal); if (dr > max) { max=dr;highest = downRight_diagonal; }
        long dl = product_list(downLeft_diagonal); if (dl > max) { max=dl;highest = downLeft_diagonal; }
        long r = product_list(right_diagonal); if (r > max) { max=r;highest = right_diagonal; }

        return max;
    }

    public void print() {
        for (int i = 0; i < lol.size(); i++) {
            for (int j = 0; j < lol.get(0).size(); j++) {
                long g = get(i,j).longValue();
                System.out.print(g+" ");
            }
            pr("");
        }
    }

    public long largest_diagonal() {
        long max = 0;
        int final_i = 0;
        int final_j = 0;
        for (int i = 0; i < lol.size(); i++) {
            for (int j = 0; j < lol.get(0).size(); j++) {
                long new_max = product_largest_diagonal_forPoint(i,j);
                if (new_max > max) {
                    max = new_max;
                    prArr(largest_diagonal_forPoint(i, j));System.out.print(" => " + new_max);
                    final_i =  i; final_j = j;
                }
            }
        }
        prArr(largest_diagonal_forPoint(final_i, final_j));
        return max;
    }

}
