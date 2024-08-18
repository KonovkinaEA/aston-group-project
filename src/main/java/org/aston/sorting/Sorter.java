package org.aston.sorting;

import java.util.Comparator;
import java.util.List;

public class Sorter<T> {
    private final Sorting<T> sortingStrategy;
    private final Comparator<T> comparator;

    public Sorter(Sorting<T> sortingStrategy, Comparator<T> comparator) {
        this.sortingStrategy = sortingStrategy;
        this.comparator = comparator;
    }

    public List<?> sort(List<?> arr){
        return sortingStrategy.sort(arr, comparator);
    }
}
