package dev.letsdebug.sort.insertion;

import dev.letsdebug.sort.provider.SortEvenCountArgumentsProvider;
import dev.letsdebug.sort.provider.SortOddCountArgumentsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

/**
 * Junit test for Insertion Sort
 */
class InsertionSortTest {

  /**
   * Test for {@link InsertionSort#sort(Comparable[]) sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0} - {1}")
  @ArgumentsSources({
    @ArgumentsSource(SortEvenCountArgumentsProvider.class),
    @ArgumentsSource(SortOddCountArgumentsProvider.class)
  })
  void sort(String[] input, String[] expectedOutput) {
    InsertionSort.sort(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }
}
