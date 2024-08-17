package org.aston.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> implements Sorting<T> {
    @Override
    public List<T> sort(List<T> arr, Comparator<T> comparator){
        List<T> sorted = new ArrayList<T>(arr);
        int n = sorted.size();
        for(int i = 0; i < n - 1; i++){
            int minIdx = i;
            T minValue = sorted.get(minIdx);
            for(int j = i + 1; j < n; j++) {
                if (comparator.compare(sorted.get(j), minValue) < 0) {
                    minIdx = j;
                    minValue = sorted.get(minIdx);
                }
            }
            Collections.swap(sorted, i, minIdx);
        }
        return sorted;
    }
}
