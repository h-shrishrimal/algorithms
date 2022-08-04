package dev.letsdebug.sort.radix;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
/**
 * Implementation of MSD (Radix sort) algorithm, using ForkJoinPool
 *
 * @author Harshad S
 */
public class ThreadedMSDSort {

  /**
   * Sort a collection of string using MSD radix sort. Uses common {@code ForkJoinPool}
   *
   * @param input data to sort.
   */
  public static void sort(String[] input) {
    ForkJoinPool pool = ForkJoinPool.commonPool();
    pool.invoke(new TMSDSort(input, 0, input.length - 1, 0));
  }
}

/** MSD Sort implementation in {@code RecursiveAction} wrapper. */
class TMSDSort extends RecursiveAction {
  private static final int R = 256; // extended ASCII alphabet size
  private String[] input;
  private int lo, hi, d;

  /**
   * Constructor
   *
   * @param input data to sort
   * @param lo start index of array
   * @param hi end index of array, inclusive
   * @param d dth character position starts from 0
   */
  public TMSDSort(String[] input, int lo, int hi, int d) {
    this.input = input;
    this.lo = lo;
    this.hi = hi;
    this.d = d;
  }

  @Override
  protected void compute() {
    sort(input, lo, hi, d);
  }

  /**
   * return the dth character value
   *
   * @param s input
   * @param d index
   * @return -1 if length of string is reached, else the dth character value
   */
  private static int charAt(String s, int d) {
    if (d == s.length()) return -1; // done processing.
    return s.charAt(d);
  }

  /**
   * Recursive implementation of MSD radix sort.
   *
   * @param input data to sort
   * @param lo start index of array
   * @param hi end index of array, inclusive
   * @param d dth character position starts from 0
   */
  private static void sort(String[] input, int lo, int hi, int d) {
    // exit condition for recursion
    if (lo >= hi) return;

    int[] count = new int[R + 2];
    String[] aux = new String[hi - lo + 1];
    // compute frequency counts
    for (int i = lo; i <= hi; i++) count[charAt(input[i], d) + 2]++;
    // transform count to indicies
    for (int r = 0; r < R + 1; r++) count[r + 1] += count[r];
    // distribute
    for (int i = lo; i <= hi; i++) {
      int c = charAt(input[i], d);
      aux[count[c + 1]++] = input[i];
    }
    // copy back
    for (int i = lo; i <= hi; i++) input[i] = aux[i - lo];

    // recursively sort for each character
    for (int r = 0; r < R; r++) {
      // optimization.
      int s = lo + count[r];
      int e = lo + count[r + 1] - 1;
      if (!(s >= e)) invokeAll(new TMSDSort(input, s, e, d + 1));
    }
  }
}
