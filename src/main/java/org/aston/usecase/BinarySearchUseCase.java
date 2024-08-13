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
    int resultIndex = 0;
    int lastIndex = sortedCollection.size() - 1;

    while(resultIndex <= lastIndex) {
      int middleIndex = resultIndex + lastIndex >>> 1;
      T middleElement = sortedCollection.get(middleIndex);
      int comparedWithMiddleElement = comparator.compare(middleElement, searchElement);
      if (comparedWithMiddleElement < 0) {
        resultIndex = middleIndex + 1;
      } else {
        if (comparedWithMiddleElement == 0) {
          return middleIndex;
        }

        lastIndex = middleIndex - 1;
      }
    }

    return -(resultIndex + 1);
  }
}
