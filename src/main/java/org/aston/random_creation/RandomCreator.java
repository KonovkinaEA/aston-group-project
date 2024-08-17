package org.aston.random_creation;

import java.util.List;

public class RandomCreator {
    private static final int MAX_CHOICE = 4;
    private static final int MIN_CHOICE = 1;
    private static final RandomStrategy RANDOM_STRATEGY = new RandomStrategy();
    private static RandomBuilderInterface randomBuilderInterface;

    public static List<?> getRandomList(int limit){
        int choice = RandomBuilderInterface.getRandomNumber(MAX_CHOICE, MIN_CHOICE);

        switch (choice) {
            case 1:
                randomBuilderInterface = new BusRandomBuilder();
                RANDOM_STRATEGY.choiceStrategy(new BusRandomBuilder(), limit);
                break;
            case 2 :
                randomBuilderInterface = new StudentRandomBuilder();
                RANDOM_STRATEGY.choiceStrategy(new StudentRandomBuilder(), limit);
                break;
            case 3 :
                randomBuilderInterface = new UserRandomBuilder();
                RANDOM_STRATEGY.choiceStrategy(new UserRandomBuilder(), limit);
                break;
        }
        return randomBuilderInterface.createRandomList(limit);
    }
}