package dev.letsdebug.sort.heap;

import dev.letsdebug.provider.SortEvenCountArgumentsProvider;
import dev.letsdebug.provider.SortOddCountArgumentsProvider;
import dev.letsdebug.sort.insertion.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

/** Junit test for Heap Sort */
public class HeapSortTest {

  /**
   * Test for {@link HeapSort#sort(Comparable[]) sort} method.
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
