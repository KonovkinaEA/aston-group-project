package org.aston;

import org.aston.creation.random.RandomCreator;

import java.util.Collections;
import java.util.List;

public class ListManager<T> {
    private final RandomCreator<T> randomCreator;
    private List<T> list;

    public ListManager(RandomCreator<T> randomCreator) {
        this.randomCreator = randomCreator;
        this.list = Collections.emptyList();
    }

    public List<T> getList() {
        return list;
    }

    public List<T> generateRandomList(int size) {
        list = randomCreator.getRandomList(size);
        return list;
    }
}
