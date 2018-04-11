package ru.parsentev.task_015;

import org.slf4j.Logger;

import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CycleShift {
    private static final Logger log = getLogger(CycleShift.class);

    private final int[] values;

    public CycleShift(final int[] values) {
        this.values = values;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CycleShift(new int[]{0, 1, 2}).shift(2)));
    }

    public int[] shift(int position) {
        int i = values[0];
        int g = position;
        for (int count = 0; count < values.length; count++) {
            g = g % values.length;
            int v = values[g];
            values[g] = i;
            g += position;
            i = v;
        }
        return values;
    }
}
