package dev.letsdebug.sort.selection;

import dev.letsdebug.sort.UtilFunctions;

/**
 * Implementation of Selection Sort algorithm.
 *
 * @author Harshad S
 */
public final class SelectionSort {

  private SelectionSort() {}

  /**
   * Implementation of Selection sort algorithm
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort(OBJ[] data) {
    /*
    Find the smallest item in the array, and exchange it with the first entry.
    Then, find the next smallest item and exchange it with the second entry.
    Continue in this way until the entire array is sorted.
    */
    int total = data.length;
    for (int idx = 0; idx < total; idx++) {
      int currMinIdx = idx;
      for (int i = currMinIdx + 1; i < total; i++) {
        if (UtilFunctions.less(data[i], data[currMinIdx])) currMinIdx = i;
      }
      UtilFunctions.swap(data, idx, currMinIdx);
    }
  }
}
