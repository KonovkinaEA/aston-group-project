package org.aston.creation.random;

import java.util.List;

public class RandomCreator {
    private static final int MAX_CHOICE = 4;
    private static final int MIN_CHOICE = 1;
    private static final RandomStrategy RANDOM_STRATEGY = new RandomStrategy();
    private static RandomBuilderInterface randomBuilderInterface;

    public static List<?> getRandomList(int limit){
        int choice = (int)RandomBuilderInterface.getRandomNumber(MAX_CHOICE, MIN_CHOICE);

        switch (choice) {
            case 1:
                randomBuilderInterface = new BusRandomBuilder();
                RANDOM_STRATEGY.choiceStrategy(new BusRandomBuilder());
                break;
            case 2 :
                randomBuilderInterface = new StudentRandomBuilder();
                RANDOM_STRATEGY.choiceStrategy(new StudentRandomBuilder());
                break;
            case 3 :
                randomBuilderInterface = new UserRandomBuilder();
                RANDOM_STRATEGY.choiceStrategy(new UserRandomBuilder());
                break;
        }
        return randomBuilderInterface.createRandomList(limit);
    }
}