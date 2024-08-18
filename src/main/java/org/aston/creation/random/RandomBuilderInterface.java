package org.aston.creation.random;

import java.util.List;

public interface RandomBuilderInterface {

    List<?> createRandomList(int limit);


    static double getRandomNumber(double max, double min){
        return (Math.random() * (max - min)) + min;
    }

}