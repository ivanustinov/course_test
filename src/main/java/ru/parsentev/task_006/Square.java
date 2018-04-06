package ru.parsentev.task_006;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Square {
    private static final Logger log = getLogger(Square.class);

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Square(final Point a, final Point b, final Point c, final Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public boolean exists() {
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double ad = a.distanceTo(d);
        if (ab == ac && ad == Math.sqrt(ab * ab + ac * ac))
            return true;
        if (ab == ad && ac == Math.sqrt(ab * ab + ad * ad))
            return true;
        if (ac == ad && ab == Math.sqrt(ac * ac + ad * ad))
            return true;
        else return false;
    }
}
