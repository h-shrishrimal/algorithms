package dev.letsdebug.sort.heap;

import dev.letsdebug.sort.UtilFunctions;

/**
 * Implementation of Heap Sort algorithm.
 *
 * @author Harshad S
 */
public final class HeapSort {

  /**
   * Implementation of Heap sort algorithm
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort(OBJ[] data) {
    int n = data.length;
    int lastNonLeafNode = n / 2 - 1;
    // heapify phase
    for (int i = lastNonLeafNode; i >= 0; i--) UtilFunctions.heapify(data, n, i);
    // sort phase
    for (int i = n - 1; i > 0; i--) {
      UtilFunctions.swap(data, i, 0); // move largest to it's correct sorted position
      UtilFunctions.heapify(data, i, 0); // call heapify on the reduced heap.
    }
  }
}
