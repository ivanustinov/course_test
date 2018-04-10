package ru.parsentev.task_016;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class TicTacToe {
    private static final Logger log = getLogger(TicTacToe.class);

    private static final int START = 1;

    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        boolean result = false;
        cycles:
        for (int x = 0; x < values.length; x++) {
            for (int y = 0; y < values.length; y++) {
                if (traversal(x, y, START, 0, 1) ||
                        traversal(x, y, START, 1, 0) ||
                        traversal(x, y, START, 1, 1) ||
                        traversal(x, y, START, -1, 1)) {
                    result = true;
                    break cycles;
                }
            }
        }
        return result;
    }

    public boolean traversal(int x, int y, int count, int stepX, int stepY) {
        boolean result = false;
        if (count == 3) {
            result = true;
        } else {
            if (x + stepX < values.length && y + stepY < values.length && x + stepX >= 0 && y + stepY >= 0
                    && values[x][y] == values[x + stepX][y + stepY]) {
                result = traversal(x + stepX, y + stepY, count + 1, stepX, stepY);
            }
        }
        return result;
    }
}
