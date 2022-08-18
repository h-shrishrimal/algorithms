package dev.letsdebug.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RecursionTest {

  @ParameterizedTest(name = "input: {0}, expected: {1}")
  @MethodSource("sortTest")
  void isArraySorted_tailRecursion(int[] input, boolean expected) {
    boolean actual = Recursion.isArraySorted_tailRecursion(input, 0, input.length);
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "input: {0}, expected: {1}")
  @MethodSource("sortTest")
  void isArraySorted_headRecursion(int[] input, boolean expected) {
    boolean actual = Recursion.isArraySorted_headRecursion(input, 0, input.length);
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "input: {0}, expected: {1}")
  @MethodSource("fibonacciTest")
  void fibonacci(int n, int expected) {
    int actual = Recursion.fibonacci(n);
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "input: {0}, expected: {1}")
  @MethodSource("numberOfways")
  void numberOfways(int noParticipants, int expected) {
    int actual = Recursion.numberOfways(noParticipants);
    Assertions.assertEquals(expected, actual);
  }

  private static Stream<Arguments> numberOfways() {
    return Stream.of(
            Arguments.arguments(0, 1),
            Arguments.arguments(1, 1),
            Arguments.arguments(2, 2),
            Arguments.arguments(3, 4),
            Arguments.arguments(4, 10));
  }

  private static Stream<Arguments> fibonacciTest() {
    return Stream.of(
        Arguments.arguments(0, 0),
        Arguments.arguments(2, 1),
        Arguments.arguments(3, 2),
        Arguments.arguments(4, 3),
        Arguments.arguments(8, 21));
  }

  private static Stream<Arguments> sortTest() {
    return Stream.of(
        Arguments.arguments(new int[] {1, 2, 3, 4, 5}, true),
        Arguments.arguments(new int[] {1, 2, 3, 4, 1}, false));
  }
}
