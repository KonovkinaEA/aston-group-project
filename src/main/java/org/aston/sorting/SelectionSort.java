package org.aston.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort<T> implements Sorting<T>{

    @Override
    public List<T> sort(List<T> arr, Comparator<T> comparator) {
        List<T> userlist = arr.stream().collect(Collectors.toList());;
        int n = userlist.size();
        for(int i = 0; i < n - 1; i++){
            int minIdx = i;
            for(int j = i+1; j < n; j++){
                if(comparator.compare(userlist.get(j), userlist.get(minIdx)) < 0)
                    minIdx = j;
            }
            if(minIdx != i)
                Collections.swap(userlist, i, minIdx);
        }
        return userlist;
    }
}
