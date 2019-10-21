package com.dnd.Utilities;

import java.util.Random;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RandomCollectionWeighted<E> {
    /*
    https://stackoverflow.com/questions/6409652/random-weighted-selection-in-java
    Here's an example of usage:

    RandomCollectionWeighted<String> rc = new RandomCollectionWeighted<>()
                              .add(40, "dog").add(35, "cat").add(25, "horse");

    for (int i = 0; i < 10; i++) {
        System.out.println(rc.next());
    }
     */
    private final NavigableMap<Double, E> map = new TreeMap<Double, E>();
    private final Random random;
    private double total = 0;

    public RandomCollectionWeighted() {
        this(new Random());
    }

    public RandomCollectionWeighted(Random random) {
        this.random = random;
    }

    public RandomCollectionWeighted<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}
