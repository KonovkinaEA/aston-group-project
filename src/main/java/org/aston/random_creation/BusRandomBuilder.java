package org.aston.random_creation;

import org.aston.model.Bus;

import java.util.List;
import java.util.stream.Stream;

class BusRandomBuilder implements RandomBuilderInterface{
    private static final List<String> BUS_MODEL = BusModelEnum.getAllModels();

    private static final int MIN_NUMBER = 100;
    private static final int MAX_NUMBER = 999;
    private static final int MAX_MILEAGE = 100000;


    private static Bus createBus(){

          return new Bus.Builder()
                    .setNumber(String.valueOf(RandomBuilderInterface.getRandomNumber(MAX_NUMBER, MIN_NUMBER)))
                    .setModel(BUS_MODEL.get(RandomBuilderInterface.getRandomNumber(BUS_MODEL.size())))
                    .setMileage(RandomBuilderInterface.getRandomNumber(MAX_MILEAGE))
                    .build();
    }

    @Override
    public List<Bus> createRandomList(int limit) {
        return Stream.generate(BusRandomBuilder::createBus)
                .limit(limit)
                .toList();
    }

}