package dev.letsdebug.sort.shell;

import dev.letsdebug.sort.UtilFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Implementation of Shell Sort algorithm.
 *
 * @author Harshad S
 */
public class ShellSort {

  /**
   * Shell sort algorithm implementation.
   *
   * @param data input to sort
   * @param gapSeqSupplier gap sequence to use for sorting
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  private static <OBJ extends Comparable<OBJ>> void sort(
      OBJ[] data, Supplier<List<Integer>> gapSeqSupplier) {

    int n = data.length;
    List<Integer> gapSequence = gapSeqSupplier.get();
    gapSequence.forEach(
        (gap -> {
          // insertion sort.
          for (int i = gap; i < n; i++)
            for (int j = i; j >= gap && UtilFunctions.less(data[j], data[j - gap]); j -= gap)
              UtilFunctions.swap(data, j, j - gap);
        }));
  }

  /**
   * Implementation of Shell sort algorithm, using original divide by 2 sequence
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort(OBJ[] data) {
    sort(data, () -> nBy2Sequence(data.length));
  }

  /**
   * Implementation of Shell sort algorithm, using 3x+1 sequence
   *
   * @param data array to sort
   * @param <OBJ> Generic. Any object that implements {@link Comparable Comparable}
   */
  public static <OBJ extends Comparable<OBJ>> void sort3xPlus1(OBJ[] data) {
    sort(data, () -> threeXplus1Sequence(data.length));
  }

  /**
   * Original gap sequence for shell sort. Here, length is continously divided by 2.
   *
   * @param arrayLength length of the array.
   * @return gapSequence for shell sort
   */
  private static List<Integer> nBy2Sequence(int arrayLength) {
    List<Integer> gapSequence = new ArrayList<>();
    int gap = arrayLength / 2;
    while (gap >= 1) {
      gapSequence.add(gap);
      gap = gap / 2;
    }
    return gapSequence;
  }

  /**
   * 3x+1 sequence for shell sort
   *
   * @param arrayLength length of the array.
   * @return gapSequence for shell sort
   */
  private static List<Integer> threeXplus1Sequence(int arrayLength) {
    List<Integer> gapSequence = new ArrayList<>();
    int gap = 1;
    while (gap < arrayLength / 3) gap = 3 * gap + 1;
    while (gap >= 1) {
      gapSequence.add(gap);
      gap = gap / 3;
    }
    return gapSequence;
  }
}
