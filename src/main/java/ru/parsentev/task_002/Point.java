package ru.parsentev.task_002;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Class Point defines a point in coordination system (x, y).
 * @author parsentev
 * @since 19.07.2016
 */
public class Point {
    private static final Logger log = getLogger(Point.class);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка:(x - " + x + " y - " + y + ")";
    }

    public double distanceTo(final Point point) {
        double dx2 = (x - point.x);
        double dy2 = (y - point.y);
        double dr = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        return dr;
    }
}
