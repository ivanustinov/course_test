package ru.parsentev.task_001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author parsentev
 * @since 18.07.2016
 */
public class Calculator {
    private double result;
    private static final Logger log = getLogger(Calculator.class);

    public double getResult() {
       return result;
    }

    public void add(double first, double second) {
       result = first + second;
    }

    public void substract(double first, double second) {
        result = first - second;
    }

    public void multiple(double first, double second) {
        result = first * second;
    }

    public void div(double first, double second) {
        if(second == 0)
            throw new IllegalStateException("Деление на ноль");
        result = first / second;
    }

    public void expand(double first, double second) {
        result = first;
        if(second == 0)
            result = 1;
        for (int index = 1; index <= second ; index++) {
            result *= first;
        }
    }
}
