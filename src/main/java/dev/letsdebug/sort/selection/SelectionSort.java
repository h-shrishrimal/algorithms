package dev.letsdebug.sort.selection;

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
        if (less(data[i], data[currMinIdx])) currMinIdx = i;
      }
      swap(data, idx, currMinIdx);
    }
  }

  /**
   * Swap items in an array.
   *
   * @param data Array, from which elements need to be swapped
   * @param firstIdx first index
   * @param secondIdx second index
   * @param <OBJ> Generic. Swap is applicable on collection of objects of any class
   */
  private static <OBJ> void swap(final OBJ[] data, final int firstIdx, final int secondIdx) {
    final OBJ temp = data[secondIdx];
    data[secondIdx] = data[firstIdx];
    data[firstIdx] = temp;
  }

  /**
   * Returns true, if object referenced by @param first is less that @param second; false otherwise;
   *
   * @param first object to compare
   * @param second object to compare
   * @return Returns true, if @param first is less that @param second; false otherwise
   * @param <OBJ> Generic. comparison is applicable on objects of any class
   */
  private static <OBJ extends Comparable<OBJ>> boolean less(OBJ first, OBJ second) {
    return first.compareTo(second) < 0;
  }
}
