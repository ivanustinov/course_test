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
    TreeSet<Integer> i = new TreeSet<>();

    public Pool(final int[][] values) {
        this.values = values;
    }

    public static void main(String[] args) {

    }

    public void counts(int x, int y, int result, int[][] values) {
        int[] t = new int[]{-1, 1};
        if (values[x][y] == 1) {
            result++;
            values[x][y] = 0;
            for (int i = 0; i < 2; i++) {
                if (checkStep(x, y, t[i], 0)) {
                    counts(x + t[i], y, result, values);
                }
                if (checkStep(x, y, 0, t[i])) {
                    counts(x, y + t[i], result, values);
                }
            }
        } else if (result > i.last()) {
            i.add(result);
        }
    }

    public boolean checkStep(int x, int y, int stepX, int stepY) {
        if ((x + stepX < values.length && x + stepX >= 0) && (y + stepY < values.length && y + stepY >= 0)) {
            return true;
        } else return false;
    }


    public int maxUnion() {
        i.add(0);
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                counts(i, j, 0, values);
            }
        }
        return i.last();
    }
}
