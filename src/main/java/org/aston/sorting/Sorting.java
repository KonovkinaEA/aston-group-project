package org.aston.sorting;

import java.util.Comparator;
import java.util.List;

public interface Sorting<T> {
    List<T> sort(List<T> arr, Comparator<T> comparator);
}
