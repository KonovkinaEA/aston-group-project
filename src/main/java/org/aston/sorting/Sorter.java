package org.aston.sorting;

import java.util.Comparator;
import java.util.List;

public class Sorter<T> {
    private final Sorting<T> sortingType;

    public Sorter(Sorting<T> sortingType){
        this.sortingType = sortingType;
    }

    public List<T> sort(List<T> arr, Comparator<T> comparator){
        return sortingType.sort(arr, comparator);
    }
}
