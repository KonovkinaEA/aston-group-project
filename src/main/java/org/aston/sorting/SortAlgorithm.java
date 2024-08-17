package org.aston.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAlgorithm<T> {
    private Sorting<T> sortingType;

    public SortAlgorithm(Sorting<T> sortingType){
        this.sortingType = sortingType;
    }

    public List<T> sort(List<T> arr, Comparator<T> comparator){
//        return sortingType.sort(arr, comparator);
    }
}
