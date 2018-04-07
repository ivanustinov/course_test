package ru.parsentev.task_014;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ReversePhrase {
    private static final Logger log = getLogger(ReversePhrase.class);
    private final String line;

    public ReversePhrase(final String line) {
        this.line = line;
    }

    public String reverse() {
        String[] str = line.split(" ");
        if (str.length != 3) {
            return line;
        }
        String v = str[0];
        str[0] = str[2] + " ";
        str[2] = " " + v;
        String reverse = "";
        for (String s : str) {
            reverse += (s);
        }
        return reverse;
    }
}
