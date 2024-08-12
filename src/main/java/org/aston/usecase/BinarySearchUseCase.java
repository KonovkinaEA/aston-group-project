package org.aston.usecase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchUseCase<T> implements SearchUseCase<T> {
  private final List<T> sortedCollection;

  public BinarySearchUseCase(List<T> sortedCollection) {
    this.sortedCollection = sortedCollection;
  }

  @Override public int search(T searchElement, Comparator<T> comparator) {
    return Collections.binarySearch(sortedCollection, searchElement, comparator);
  }
}
