package ru.parsentev.task_012;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class SequenceArray {
    private static final Logger log = getLogger(SequenceArray.class);

    private final int[] values;

    public SequenceArray(final int[] values) {
        this.values = values;
    }

    public boolean containsOneSequence() {
        int t = 0;
        for (int value : values) {
            t = (value == 1 ? ++t : 0);
            if (t == 3) {
                return true;
            }
        }
        return false;
    }
}