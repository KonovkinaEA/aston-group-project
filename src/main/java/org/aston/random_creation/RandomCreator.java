package org.aston.random_creation;

import java.util.List;

public class RandomCreator {

    private final int choice = (int) (Math.random() * 3) + 1;

    public List<?> getRandomList(int limit){

        if (choice == 1) {
            return BusRandomBuilder.createRandomList(limit);
        } else if (choice == 2) {
            return UserRandomBuilder.createRandomList(limit);
        } else {
            return StudentRandomBuilder.createRandomList(limit);
        }
    }
}
