package ru.parsentev.task_019;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Maze {
    private static final Logger log = getLogger(Maze.class);

    private final int[][] values;

    public Maze(final int[][] values) {
        this.values = values;
    }

    public static void main(String[] args) {
        System.out.println(new Maze(new int[][]{{1, 0, 0},
                                                {1, 1, 1},
                                                {1, 1, 1}}).solution(new Point(0, 0), new Point(1, 2)));
    }

    public List<Point> solution(Point start, Point finish) {
        return counts(start, finish, values, new ArrayList<Point>());
    }

    public List<Point> counts(Point start, Point finish, int[][] values, ArrayList<Point> f) {
        ArrayList<List<Point>> list = new ArrayList<>();
        ArrayList<Point> p = new ArrayList<>(f);
        int[] t = new int[]{-1, 0, 1, 0};
        int[] r = new int[]{0, 1, 0, -1};
        int x = start.getX();
        int y = start.getY();
        if (values[x][y] == 1) {
            p.add(start);
            if (x == finish.getX() && y == finish.getY()) {
                return p;
            }
            values[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                if (checkStep(x, y, t[i], r[i])) {
                    List<Point> w = counts(new Point(x + t[i], y + r[i]), finish, values, p);
                    if (w != null) {
                        list.add(w);
                    } else {
                        continue;
                    }
                }
            }
        } else return null;
        Collections.sort(list, new Comparator<List<Point>>() {
            @Override
            public int compare(List<Point> o1, List<Point> o2) {
                if (o1.size() == o2.size()) return 0;
                else if (o1.size() > o2.size()) return 1;
                else return -1;
            }
        });
        if (list.size() > 0)
            return list.get(0);
        else return null;
    }

    public boolean checkStep(int x, int y, int stepX, int stepY) {
        if ((x + stepX < values.length && x + stepX >= 0) && (y + stepY < values.length && y + stepY >= 0)) {
            return true;
        } else return false;
    }

}
