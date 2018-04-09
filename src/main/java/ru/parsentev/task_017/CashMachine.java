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
    int t = 0;
    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public static void main(String[] args) {

    }

    public List<List<Integer>> exchange(int i) {
        throw  new UnsupportedOperationException();
    }
}
