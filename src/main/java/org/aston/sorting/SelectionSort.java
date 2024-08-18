package org.aston.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> implements Sorting<T> {
    @Override
    public List<?> sort(List<?> arr, Comparator<T> comparator){
        List<?> sorted = new ArrayList<>(arr);
        int n = sorted.size();
        for(int i = 0; i < n - 1; i++){
            int minIdx = i;
            T minValue = (T)sorted.get(minIdx);
            for(int j = i + 1; j < n; j++) {
                if (comparator.compare((T)sorted.get(j), minValue) < 0) {
                    minIdx = j;
                    minValue = (T)sorted.get(minIdx);
                }
            }
            Collections.swap(sorted, i, minIdx);
        }

        return sorted;
    }
}
