package dev.letsdebug.sort.insertion;

import dev.letsdebug.sort.UtilFunctions;

/**
 * Implementation of Insertion Sort algorithm.
 *
 * @author Harshad S
 */
public final class InsertionSort {

  private InsertionSort() {}

  /**
   * Implementation of Insertion sort algorithm
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort(OBJ[] data) {
    int total = data.length;
    /*
    Loop over positions, starting with index 1.
    insert it into the correct place in the sorted subarray to the left of that position.
    */
    for (int i = 1; i < total; i++) {
      for (int j = i; j > 0 && UtilFunctions.less(data[j], data[j - 1]); j--) {
        UtilFunctions.swap(data, j, j - 1);
      }
    }
  }
}
