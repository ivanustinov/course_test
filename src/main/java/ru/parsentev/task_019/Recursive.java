package ru.parsentev.task_019;

import java.util.ArrayList;

public class Recursive {

    public static void main(String[] args) {
        System.out.println(new Recursive().recu(new ArrayList<Integer>()));
    }

    public int recu(ArrayList<Integer> r) {
        r.add(1);
        while (r.size() < 3) {
            recu(r);
        }
        return r.size();
    }
}
