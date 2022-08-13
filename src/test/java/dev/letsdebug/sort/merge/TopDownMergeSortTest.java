package dev.letsdebug.sort.merge;

import dev.letsdebug.provider.SortEvenCountArgumentsProvider;
import dev.letsdebug.provider.SortOddCountArgumentsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

/** Junit test for Merge Sort */
class TopDownMergeSortTest {
  /**
   * Test for {@link TopDownMergeSort#sort(Comparable[]) sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0} - {1} - {1}")
  @ArgumentsSources({
    @ArgumentsSource(SortEvenCountArgumentsProvider.class),
    @ArgumentsSource(SortOddCountArgumentsProvider.class)
  })
  void sort(String[] input, String[] expectedOutput) {
    TopDownMergeSort.sort(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }

  /**
   * Test for {@link TopDownMergeSort#inPlaceMergeUsingShellSort(Comparable[]) sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0} - {1} - {1}")
  @ArgumentsSources({
    @ArgumentsSource(SortEvenCountArgumentsProvider.class),
    @ArgumentsSource(SortOddCountArgumentsProvider.class)
  })
  void inPlaceMergeUsingShellSort(String[] input, String[] expectedOutput) {
    TopDownMergeSort.inPlaceMergeUsingShellSort(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }

  /**
   * Test for {@link TopDownMergeSort#inPlaceMergeUsingBruteForce(Comparable[])} (Comparable[])
   * sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0} - {1}")
  @ArgumentsSources({
    @ArgumentsSource(SortEvenCountArgumentsProvider.class),
    @ArgumentsSource(SortOddCountArgumentsProvider.class)
  })
  void inPlaceMergeUsingBruteForce(String[] input, String[] expectedOutput) {
    TopDownMergeSort.inPlaceMergeUsingBruteForce(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }
}
