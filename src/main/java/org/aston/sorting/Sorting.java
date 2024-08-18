package org.aston.sorting;

import java.util.Comparator;
import java.util.List;

public interface Sorting<T> {
    List<?> sort(List<?> arr, Comparator<T> comparator);
}


