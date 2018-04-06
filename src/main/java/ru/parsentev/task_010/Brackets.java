package ru.parsentev.task_010;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Brackets {
    private static final Logger log = getLogger(Brackets.class);
    private final String line;

    public Brackets(final String line) {
        this.line = line;
    }


    public boolean isCorrect() {
        char[] c = line.toCharArray();
        int l = 0;
        int r = 0;
        for (char c1 : c) {
            switch (c1) {
                case '(':
                    l++;
                    break;
                case ')':
                    r++;
            }
        }
        if (l == r) {
            return true;
        } else return false;
    }
}
