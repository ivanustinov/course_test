package ru.parsentev.task_007;

import org.slf4j.Logger;
import ru.parsentev.task_001.Calculator;

import java.util.Scanner;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!s.equals("")) {
            Expression exp = new Expression(s);
            System.out.println(exp.calc());
            s = sc.nextLine();
        }
        sc.close();
    }

    private final String expr;
    Calculator cal = new Calculator();
    String[] str;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {
        char[] c = expr.toCharArray();
        for (char c1 : c) {
            switch (c1) {
                case '+':
                    str = expr.split("\\+");
                    if (str.length == 2)
                        cal.add(Double.valueOf(str[0]), Double.valueOf(str[1]));
                    else throw new IllegalStateException();
                    return cal.getResult();
                case '-':
                    str = expr.split("-");
                    if (str.length == 2)
                        cal.substract(Double.valueOf(str[0]), Double.valueOf(str[1]));
                    else throw new IllegalStateException();
                    return cal.getResult();
                case '*':
                    str = expr.split("\\*");
                    if (str.length == 2)
                        cal.multiple(Double.valueOf(str[0]), Double.valueOf(str[1]));
                    else throw new IllegalStateException();
                    return cal.getResult();
                case '/':
                    str = expr.split("/");
                    if (str.length == 2)
                        cal.div(Double.valueOf(str[0]), Double.valueOf(str[1]));
                    else throw new IllegalStateException();
                    return cal.getResult();
            }
        }
        throw new IllegalStateException();
    }
}
