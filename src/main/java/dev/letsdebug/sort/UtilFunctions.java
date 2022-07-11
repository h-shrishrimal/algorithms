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
   * @param <OBJ> Generic. comparison is applicable on objects of any class
   */
  public static <OBJ extends Comparable<OBJ>> boolean less(OBJ first, OBJ second) {
    return first.compareTo(second) < 0;
  }
}
