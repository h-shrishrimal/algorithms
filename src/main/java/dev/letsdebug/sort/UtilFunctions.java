package dev.letsdebug.sort;

/**
 * Utility functions that are used in various classes
 *
 * @author Harshad S
 */
public final class UtilFunctions {

  private UtilFunctions() {}

  /**
   * Swap items in an array.
   *
   * @param data Array, from which elements need to be swapped
   * @param firstIdx first index
   * @param secondIdx second index
   * @param <OBJ> Generic. Swap is applicable on collection of objects of any class
   */
  public static <OBJ> void swap(final OBJ[] data, final int firstIdx, final int secondIdx) {
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
   */
  public static boolean less(Comparable first, Comparable second) {
    return first.compareTo(second) < 0;
  }

  /**
   * Merge 2 sorted arrays into 1, using additional space
   *
   * @param data sorted data between [lo .. mid] and [mid+1 .. hi]
   * @param aux empty array required for merging
   * @param lo start index in array
   * @param mid midpoint
   * @param hi end index in array
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ> void merge(
      Comparable<? super OBJ>[] data, Comparable<? super OBJ>[] aux, int lo, int mid, int hi) {
    // pre condition: data[lo ... mid] & data[mid+1 ... hi] is sorted
    // Objective: merge data[lo ... mid] & data[mid+1 ... hi]

    // copy to aux
    for (int idx = lo; idx <= hi; idx++) aux[idx] = data[idx];

    int leftIdx = lo;
    int rightIdx = mid + 1;

    // merge back to data from aux
    for (int k = lo; k <= hi; k++) {
      // left array is completely merged, copy remaining from right.
      if (leftIdx > mid) {
        data[k] = aux[rightIdx++];
        continue;
      }
      // right array is completely merged, copy remaining from left.
      if (rightIdx > hi) {
        data[k] = aux[leftIdx++];
        continue;
      }
      if (UtilFunctions.less(aux[leftIdx], aux[rightIdx])) data[k] = aux[leftIdx++];
      else data[k] = aux[rightIdx++];
    }
  }

  /**
   * Merge 2 sorted arrays into 1, using shell sort.
   *
   * @param data sorted data between [lo .. mid] and [mid+1 .. hi]
   * @param lo start index in array
   * @param mid midpoint. ignored in this implementation.
   * @param hi end index in array
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ> void shellSortInPlaceMerge(
      Comparable<? super OBJ>[] data, int lo, int mid, int hi) {
    // pre condition: data[lo ... mid] & data[mid+1 ... hi] is sorted
    // Objective: merge data[lo ... mid] & data[mid+1 ... hi]
    int n = hi - lo + 1; // number of elements in array.
    int gap = n / 2;
    while (gap >= 1) {
      for (int i = lo + gap; i < n; i++) {
        for (int j = i;
            j >= (lo + gap) && UtilFunctions.less(data[j], data[j - gap]);
            j = j - gap) {
          UtilFunctions.swap(data, j, j - gap);
        }
      }
      gap = gap / 2;
    }
  }

  /**
   * Merge 2 sorted arrays into 1, by repeatedly swapping elements. <br>
   * Time Complexity : O(n^2) <br>
   * Space complexity : O(1)
   *
   * @param data sorted data between [lo .. mid] and [mid+1 .. hi]
   * @param lo start index in array
   * @param mid midpoint.
   * @param hi end index in array
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ> void bruteForceInPlaceMerge(
      Comparable<? super OBJ>[] data, int lo, int mid, int hi) {
    // pre condition: data[lo ... mid] & data[mid+1 ... hi] is sorted
    // Objective: merge data[lo ... mid] & data[mid+1 ... hi]
    int leftIdx = lo;
    int rightIdx = mid + 1;
    while (leftIdx <= mid && rightIdx <= hi) {
      // increment left since the element is in its correct sorted position
      if (UtilFunctions.less(data[leftIdx], data[rightIdx])) leftIdx++;
      else {
        // shift all elements between leftIdx (inclusive) and rightIdx
        // to the right by 1 and then move element at rightIdx to leftIdx
        int idx = rightIdx;
        while (idx > leftIdx) UtilFunctions.swap(data, idx, --idx);
        // get the new leftIdx, rightIdx and mid
        leftIdx++;
        mid++;
        rightIdx++;
      }
    }
  }

  /**
   * max-heapify an array
   *
   * @param arr - data
   * @param n - size of heap
   * @param i - array index. Represents sub-tree rooted at node i.
   */
  public static <OBJ extends Comparable<OBJ>> void heapify(OBJ[] arr, int n, int i) {

    int currentLargestIdx = i;
    int j = 2 * i;
    int lChildIdx = j + 1;
    int rChildIdx = j + 2;

    // compare the current largest with left child
    if (lChildIdx < n && UtilFunctions.less(arr[currentLargestIdx], arr[lChildIdx]))
      currentLargestIdx = lChildIdx;

    // compare the current largest with right child
    if (rChildIdx < n && UtilFunctions.less(arr[currentLargestIdx], arr[rChildIdx]))
      currentLargestIdx = rChildIdx;

    // this if condition also acts as exit condition for recursion
    if (i != currentLargestIdx) {
      UtilFunctions.swap(arr, i, currentLargestIdx);
      heapify(arr, n, currentLargestIdx); // after swapping; heapify the affected sub-tree
    }
  }
}
