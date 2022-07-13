package dev.letsdebug.sort.shell;

import dev.letsdebug.provider.SortEvenCountArgumentsProvider;
import dev.letsdebug.provider.SortOddCountArgumentsProvider;
import dev.letsdebug.sort.insertion.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

/** Junit test for Shell Sort */
public class ShellSortTest {
  /**
   * Test for {@link ShellSort#sort(Comparable[]) sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0}")
  @ArgumentsSources({
    @ArgumentsSource(SortEvenCountArgumentsProvider.class),
    @ArgumentsSource(SortOddCountArgumentsProvider.class)
  })
  void sort(String[] input, String[] expectedOutput) {
    ShellSort.sort(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }

  /**
   * Test for {@link ShellSort#sort3xPlus1(Comparable[])} (Comparable[]) sort} method.
   *
   * @param input array to sort
   * @param expectedOutput expected output
   */
  @ParameterizedTest(name = "input {index} - {0}")
  @ArgumentsSources({
    @ArgumentsSource(SortEvenCountArgumentsProvider.class),
    @ArgumentsSource(SortOddCountArgumentsProvider.class)
  })
  void sort3xPlus1(String[] input, String[] expectedOutput) {
    ShellSort.sort3xPlus1(input); // method under test
    Assertions.assertArrayEquals(input, expectedOutput);
  }
}
