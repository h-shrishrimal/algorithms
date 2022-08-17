package dev.letsdebug.example;

public class Recursion {

  /**
   * check if array is sorted or not using recursion.
   *
   * @param arr input
   * @param idx start index
   * @param N total number of elements
   * @return {@code true} if array sorted, {@code false} otherwise
   */
  public static boolean isArraySorted_tailRecursion(int[] arr, int idx, int N) {
    // exit condition
    if (idx == N - 1) return true;
    if (arr[idx] < arr[idx + 1] && isArraySorted_tailRecursion(arr, idx + 1, N)) return true;
    return false;
  }

  /**
   * check if array is sorted or not using recursion.
   *
   * @param arr input
   * @param idx start index
   * @param N total number of elements
   * @return {@code true} if array sorted, {@code false} otherwise
   */
  public static boolean isArraySorted_headRecursion(int[] arr, int idx, int N) {
    // exit condition
    if (idx == N - 1) return true;
    if (isArraySorted_headRecursion(arr, idx + 1, N) && arr[idx] < arr[idx + 1]) return true;
    return false;
  }

  /**
   * Fibonacci series
   *
   * @param n
   * @return nth fibonacci number
   */
  public static int fibonacci(int n) {
    // exit condition
    if (n == 0 || n == 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  /**
   * Count pairs when a person can pair with at-most one
   *
   * @param n number of participants
   * @return count the number of ways
   */
  public static int numberOfways(int n) {
    // exit condition
    if (n == 0 || n == 1) return 1;
    // 1. remain single. number of participants reduce to n-1
    // 2. pair with one of (n-1). number of participants reduce to n-2
    return numberOfways(n - 1) + (n - 1) * numberOfways(n - 2);
  }
}
