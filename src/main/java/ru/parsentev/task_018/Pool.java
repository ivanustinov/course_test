package ru.parsentev.task_018;

import org.slf4j.Logger;

import java.util.TreeSet;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Pool {
    private static final Logger log = getLogger(Pool.class);

    private final int[][] values;


    public Pool(final int[][] values) {
        this.values = values;
    }

    public static void main(String[] args) {
        System.out.println(new Pool(new int[][]{
                {1, 0},
                {1, 0}
        }).maxUnion());
    }

    public int counts(int x, int y, int result, int[][] values) {
        int[] t = new int[]{-1, 0, 1, 0};
        int[] r = new int[]{0, 1, 0, -1};
        TreeSet<Integer> g = new TreeSet<>();
        if (values[x][y] == 1) {
            result++;
            values[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                if (checkStep(x, y, t[i], r[i])) {
                    g.add(counts(x + t[i], y + r[i], result, values));
                }
            }
        }
        g.add(result);
        return g.last();
    }

    public boolean checkStep(int x, int y, int stepX, int stepY) {
        if ((x + stepX < values.length && x + stepX >= 0) && (y + stepY < values.length && y + stepY >= 0)) {
            return true;
        } else return false;
    }


    public int maxUnion() {
        TreeSet<Integer> g = new TreeSet<>();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                g.add(counts(i, j, 0, values));
            }
        }
        return g.last();
    }
}
