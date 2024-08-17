package org.aston.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> extends SortAlgorithm<T>{
    public SelectionSort(Sorting<T> sortingType) {
        super(sortingType);
    }

    @Override
    public List<T> sort(List<T> arr, Comparator<T> comparator) {
        return super.sort(arr, comparator);
    }
}
