package dev.letsdebug.sort.selection;

import dev.letsdebug.sort.provider.SortEvenCountArgumentsProvider;
import dev.letsdebug.sort.provider.SortOddCountArgumentsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

/**
 * Junit test for Selection Sort
 */
public class SelectionSortTest {

  /**
   * Test for {@link SelectionSort#sort(Comparable[]) sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0} - {1}")
  @ArgumentsSources({
    @ArgumentsSource(SortOddCountArgumentsProvider.class),
    @ArgumentsSource(SortEvenCountArgumentsProvider.class)
  })
  void sort(String[] input, String[] expectedOutput) {
    SelectionSort.sort(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }
}
