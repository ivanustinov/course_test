package ru.parsentev.task_003;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {
    private static final Logger log = getLogger(Triangle.class);

    protected final Point a;
    protected final Point b;
    protected final Point c;

    public Triangle(final Point a, final Point b, final Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean exists() {
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double cb = c.distanceTo(b);
        if(ab + ac == cb || ab + cb == ac || ac + cb == ab)
            return false;
        else return true;
    }

    public double area() {
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double cb = c.distanceTo(b);
        if (exists()) {
            double p = (ab + ac + cb) / 2;
            return Math.sqrt(p * (p - ab) * (p - ac) * (p - cb));
        } else throw new IllegalStateException();
    }
}
