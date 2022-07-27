package dev.letsdebug.sort.merge;

import dev.letsdebug.sort.UtilFunctions;

/**
 * Implementation of bottom-up merge sort algorithm.
 *
 * @author Harshad S
 */
public class BottomUpMergeSort {

  private BottomUpMergeSort() {}

  /**
   * Implementation of merge sort algorithm, using bottom-up approach.
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort(OBJ[] data) {
    int n = data.length;
    Comparable[] aux = new Comparable[n];
    /*
     Assuming n = 17, following are the values for indices (lo,mid,hi) to the merge function
     sz = 1 ---(0,0,1) (2,2,3) (4,4,5) (6,6,7) (8,8,9) (10,10,11) (12,12,13) (14,14,15)
     sz = 2 ---(0,1,3) (4,5,7) (8,9,11) (12,13,15)
     sz = 4 ---(0,3,7) (8,11,15)
     sz = 8 ---(0,7,15)
     sz = 16 ---(0,15,16)
    */
    for (int sz = 1; sz < n; sz = sz * 2) {
      for (int lo = 0; lo < n - sz; lo = lo + 2 * sz) {
        int mid = lo + sz - 1;
        int hi = Math.min(lo + 2 * sz - 1, n - 1);
        UtilFunctions.merge(data, aux, lo, mid, hi);
      }
    }
  }

  /**
   * Implementation of merge sort algorithm. In this implementation merging is achieved using shell
   * sort
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void inPlaceMergeUsingShellSort(OBJ[] data) {
    int n = data.length;
    /*
     Assuming n = 17, following are the values for indices (lo,mid,hi) to the merge function
     sz = 1 ---(0,0,1) (2,2,3) (4,4,5) (6,6,7) (8,8,9) (10,10,11) (12,12,13) (14,14,15)
     sz = 2 ---(0,1,3) (4,5,7) (8,9,11) (12,13,15)
     sz = 4 ---(0,3,7) (8,11,15)
     sz = 8 ---(0,7,15)
     sz = 16 ---(0,15,16)
    */
    for (int sz = 1; sz < n; sz = sz * 2) {
      for (int lo = 0; lo < n - sz; lo = lo + 2 * sz) {
        int mid = lo + sz - 1;
        int hi = Math.min(lo + 2 * sz - 1, n - 1);
        UtilFunctions.shellSortInPlaceMerge(data, lo, mid, hi);
      }
    }
  }

  /**
   * Implementation of merge sort algorithm. In this implementation merging is done using repeatedly
   * swapping elements
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void inPlaceMergeUsingBruteForce(OBJ[] data) {
    int n = data.length;
    /*
     Assuming n = 17, following are the values for indices (lo,mid,hi) to the merge function
     sz = 1 ---(0,0,1) (2,2,3) (4,4,5) (6,6,7) (8,8,9) (10,10,11) (12,12,13) (14,14,15)
     sz = 2 ---(0,1,3) (4,5,7) (8,9,11) (12,13,15)
     sz = 4 ---(0,3,7) (8,11,15)
     sz = 8 ---(0,7,15)
     sz = 16 ---(0,15,16)
    */
    for (int sz = 1; sz < n; sz = sz * 2) {
      for (int lo = 0; lo < n - sz; lo = lo + 2 * sz) {
        int mid = lo + sz - 1;
        int hi = Math.min(lo + 2 * sz - 1, n - 1);
        UtilFunctions.bruteForceInPlaceMerge(data, lo, mid, hi);
      }
    }
  }
}
