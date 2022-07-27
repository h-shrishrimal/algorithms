package dev.letsdebug.sort.radix;

import java.util.Arrays;

/**
 * Implementation of LSD (Radix sort) algorithm.
 *
 * @author Harshad S
 */
public class LSDSort {

  /**
   * Sort a collection of string using radix sort. All elements in the collection should be of same
   * length.
   *
   * @param input data to sort.
   * @throws Exception if elements in the collection are not of same length
   */
  public static void sort(String[] input) throws Exception {

    final int n = input.length;
    if (n == 0) return; // return if array empty

    final int w = input[0].length();

    // check if all input is of same length
    if (Arrays.stream(input).filter(d -> d.length() != w).findFirst().isPresent())
      throw new Exception("String must have fixed length");

    int R = 256; // extended ASCII alphabet size
    String[] aux = new String[n]; // aux array used for counting sort
    int[] count = new int[R + 1];
    // count sort on the dth character
    for (int d = w - 1; d >= 0; d--) {
      // initialize count
      for (int i = 0; i < R; i++) count[i] = 0;
      // compute frequency counts
      for (int i = 0; i < n; i++) count[input[i].charAt(d) + 1]++;
      // compute cumulatives
      for (int i = 0; i < R; i++) count[i + 1] += count[i];
      // move data to aux. sorted by dth character
      for (int i = 0; i < n; i++) aux[count[input[i].charAt(d)]++] = input[i];
      // copy back the data
      for (int i = 0; i < n; i++) input[i] = aux[i];
    }
  }
}
