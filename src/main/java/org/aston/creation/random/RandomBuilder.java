package org.aston.creation.random;

import java.util.List;

public interface RandomBuilder<T> {

    static double getRandomNumber(double max, double min) {
        return (Math.random() * (max - min)) + min;
    }

    List<T> createRandomList(int limit);
}
