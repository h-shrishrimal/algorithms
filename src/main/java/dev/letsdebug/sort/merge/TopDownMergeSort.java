package dev.letsdebug.sort.merge;

import dev.letsdebug.sort.UtilFunctions;

/**
 * Implementation of top-down merge sort algorithm.
 *
 * @author Harshad S
 */
public class TopDownMergeSort {
  private TopDownMergeSort() {}

  /**
   * Implementation of merge sort algorithm
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort(OBJ[] data) {
    Comparable[] aux = new Comparable[data.length];
    mergeSort(data, aux, 0, data.length - 1);
  }

  /**
   * Implementation of merge sort algorithm. In this implementation merging is achieved using shell
   * sort
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void inPlaceMergeUsingShellSort(OBJ[] data) {
    inPlaceMergeUsingShellSort(data, 0, data.length - 1);
  }

  /**
   * Implementation of merge sort algorithm. In this implementation merging is done using repeatedly
   * swapping elements
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void inPlaceMergeUsingBruteForce(OBJ[] data) {
    inPlaceMergeUsingBruteForce(data, 0, data.length - 1);
  }

  /**
   * Top down recursive implementation of merge sort.
   *
   * @param data data to sort
   * @param aux array that is required for merging
   * @param lo start index in array
   * @param hi end index in array
   */
  private static void mergeSort(Comparable[] data, Comparable[] aux, int lo, int hi) {

    if (lo >= hi) return; // exit condition
    int mid = lo + (hi - lo) / 2; // sub-divide the array

    // recursively sort the sub-arrays
    mergeSort(data, aux, lo, mid);
    mergeSort(data, aux, mid + 1, hi);

    UtilFunctions.merge(data, aux, lo, mid, hi); // merge the sorted sub-arrays
  }

  /**
   * Top down recursive implementation of merge sort, using shell sort in-place merge.
   *
   * @param data data to sort
   * @param lo start index in array
   * @param hi end index in array
   */
  private static void inPlaceMergeUsingShellSort(Comparable[] data, int lo, int hi) {

    if (lo >= hi) return; // exit condition
    int mid = lo + (hi - lo) / 2; // sub-divide the array

    // recursively sort the sub-arrays
    inPlaceMergeUsingShellSort(data, lo, mid);
    inPlaceMergeUsingShellSort(data, mid + 1, hi);

    UtilFunctions.shellSortInPlaceMerge(data, lo, mid, hi); // merge the sorted sub-arrays
  }

  /**
   * Top down recursive implementation of merge sort, using brute force in-place merge.
   *
   * @param data data to sort
   * @param lo start index in array
   * @param hi end index in array
   */
  private static void inPlaceMergeUsingBruteForce(Comparable[] data, int lo, int hi) {

    if (lo >= hi) return; // exit condition
    int mid = lo + (hi - lo) / 2; // sub-divide the array

    // recursively sort the sub-arrays
    inPlaceMergeUsingBruteForce(data, lo, mid);
    inPlaceMergeUsingBruteForce(data, mid + 1, hi);

    UtilFunctions.bruteForceInPlaceMerge(data, lo, mid, hi); // merge the sorted sub-arrays
  }
}
