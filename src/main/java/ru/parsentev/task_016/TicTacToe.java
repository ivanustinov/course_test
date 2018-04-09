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
        if (traversal(0, 0, START, 0, 1) ||
                traversal(0, 0, START, 1, 0) ||
                traversal(0, 0, START, 1, 1)||
                traversal(2, 0, START, -1, 1)) {
            result = true;
        }
        return result;
    }

    public boolean traversal(int x, int y, int count, int stepX, int stepY) {
        boolean result = false;
        if (count == 3) {
            result = true;
        } else {
            if (x + stepX < values.length && y + stepY < values.length &&
                    values[x][y] == values[x + stepX][y + stepY] && values[x][y] == 1) {
                result = traversal(x + stepX, y + stepY, count + 1, stepX, stepY);
            }
        }
        return result;
    }
}
