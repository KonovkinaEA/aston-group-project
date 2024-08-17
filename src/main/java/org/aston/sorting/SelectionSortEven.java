package org.aston.sorting;

import java.util.Comparator;
import java.util.List;

public class SelectionSortEven<T> extends SortAlgorithm<T>{
    public SelectionSortEven(Sorting<T> sortingType){
        super(sortingType);
    }

    @Override
    public List<T> sort(List<T> arr, Comparator<T> comparator) {
        return super.sort(arr, comparator);
    }
}
