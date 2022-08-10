package dev.letsdebug.sort.radix;

import dev.letsdebug.sort.UtilFunctions;

/**
 * Implementation of MSD (Radix sort) algorithm. In this implementation we are not using an
 * auxiliary array, for counting sort. We attempt in-place permutation
 *
 * @author Harshad S
 */
public class InplaceMSD {
  private static final int R = 256; // extended ASCII alphabet size

  /**
   * Sort a collection of string using MSD radix sort.
   *
   * @param input data to sort.
   */
  public static void sort(String[] input) {
    sort(input, 0, input.length - 1, 0);
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

    // compute frequency counts
    int[] heads = new int[R + 2];
    int[] tails = new int[R + 1];
    for (int i = lo; i <= hi; i++) {
      int c = charAt(input[i], d);
      heads[c + 2]++;
    }

    // transform counts to indices
    heads[0] = lo;
    for (int r = 0; r < R + 1; r++) {
      heads[r + 1] += heads[r];
      tails[r] = heads[r + 1];
    }

    // sort by d-th character in-place
    // for each radix, put the elements in the correct sorted position.
    // as an element is placed in its correct sorted position, increment heads[r]
    // when heads[r] matches tails[r], increment r and proceed further
    for (int r = 0; r < R + 1; r++) {
      while (heads[r] < tails[r]) {
        int idx_r = heads[r];
        int c = charAt(input[idx_r], d);
        // place 'c' in its correct sorted position
        // keep doing it till we find an element with radix r
        while (c + 1 != r) {
          // move c/input[idx_r] at it's correct position.
          UtilFunctions.swap(input, idx_r, heads[c + 1]++);
          c = charAt(input[idx_r], d); // start with the new c
        }
        heads[r]++;
      }
    }

    // recursively sort for each character (excludes sentinel -1)
    for (int r = 0; r < R; r++) sort(input, tails[r], tails[r + 1] - 1, d + 1);
  }
}
