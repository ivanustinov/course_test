package ru.parsentev.task_017;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);
    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public static void main(String[] args) {
        System.out.println(new CashMachine(new int[]{4, 2}).exchange(6));
    }

    public List<List<Integer>> exchange(int i) {
        return exchange(i, 0);
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int j = 0; j < values.length; j++) {
//            List<Integer> g = ex(i, values[j], j, new ArrayList<Integer>());
//            if (g != null)
//                lists.add(g);
//        }
//        return lists;
    }

    public List<List<Integer>> exchange(int note, int step) {
        List<List<Integer>> data = new ArrayList<>();
        for (int index = step; index < values.length; index++) {
            final int value = values[index];
            if (note - values[index] < 0) {
                continue;
            }
            int rsl = note - values[index];
            if (rsl == 0) {
                data.add(new ArrayList<>(Collections.singletonList(value)));
            } else {
                for (List<Integer> sub : exchange(rsl, index)) {
                    sub.add(0, value);
                    data.add(sub);
                }
            }
        }
        return data;
    }
//    public List<Integer> ex(int dollar, int coin, int number, List<Integer> f) {
//        int y = dollar / coin;
//        for (int i = 0; i < y; i++) {
//            f.add(coin);
//        }
//        number++;
//        if (dollar - y * coin > 0 && number < values.length) {
//            return ex(dollar - y * coin, values[number], number, f);
//        } else if (dollar - y * coin > 0) {
//            return null;
//        } else {
//            return f;
//        }
//    }

}
