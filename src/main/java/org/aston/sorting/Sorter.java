package org.aston.sorting;

import java.util.Comparator;
import java.util.List;

public class Sorter<T> {
    private final Sorting<T> sortingStrategy;

    public Sorter(Sorting<T> sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public List<T> sort(List<T> arr, Comparator<T> comparator){
        return sortingStrategy.sort(arr, comparator);
    }
}
