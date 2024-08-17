package org.aston.creation.random;

import org.aston.model.Bus;

import java.util.List;
import java.util.stream.Stream;

class BusRandomBuilder{
    private static final List<String> BUS_MODEL = BusModelEnum.getAllModels();

    private static final int MIN_NUMBER = 100;
    private static final int MAX_NUMBER = 999;


    private static Bus createBus(){

          return new Bus.Builder()
                    .setNumber(String.valueOf((int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER)))
                    .setModel(BUS_MODEL.get((int) (Math.random() * BUS_MODEL.size())))
                    .setMileage((int) (Math.random() * 100000))
                    .build();
    }


    static List<Bus> createRandomList(int limit) {

        return Stream.generate(BusRandomBuilder::createBus)
                .limit(limit)
                .toList();
    }

}
