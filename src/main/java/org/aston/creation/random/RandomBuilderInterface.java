package org.aston.random_creation;

import java.util.List;

public interface RandomBuilderInterface {

    List<?> createRandomList(int limit);

    static int getRandomNumber(int max, int min){
        return (int) (Math.random() * (max - min)) + min;
    }

    static double getRandomNumber(double max, double min){
        return (Math.random() * (max - min)) + min;
    }

    static int getRandomNumber(int number){
        return (int) (Math.random() * number);
    }
}