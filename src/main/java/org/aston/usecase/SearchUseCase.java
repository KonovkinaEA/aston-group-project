package org.aston.usecase;

import java.util.Comparator;

public interface SearchUseCase<T> {
  int search(T element, Comparator<T> comparator);
}
