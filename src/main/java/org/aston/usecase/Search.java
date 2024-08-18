package org.aston.usecase;

import java.util.List;

public interface Search<T> {
    int search(List<T> list, T element);
}
