package org.aston.creation.random;

import java.util.List;

@FunctionalInterface
public interface RandomCreator<T> {
    List<T> getRandomList(int size);
}
