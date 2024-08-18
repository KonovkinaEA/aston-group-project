package org.aston.usecase;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<T> implements Search<T> {
    private final Comparator<T> comparator;

    public BinarySearch(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int search(List<T> list, T searchElement) {
        int resultIndex = 0;
        int lastIndex = list.size() - 1;

        while (resultIndex <= lastIndex) {
            int middleIndex = resultIndex + lastIndex >>> 1;
            T middleElement = list.get(middleIndex);
            int comparedWithMiddleElement = comparator.compare(middleElement, searchElement);
            if (comparedWithMiddleElement < 0) {
                resultIndex = middleIndex + 1;
            } else {
                if (comparedWithMiddleElement == 0) {
                    return middleIndex;
                }

                lastIndex = middleIndex - 1;
            }
        }

        return -(resultIndex + 1);
    }
}
