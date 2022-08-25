package dev.letsdebug.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BracketsTest {

  @ParameterizedTest(name = "input: {0}")
  @MethodSource("testData")
  void generateParenthesisRecursive_1(final int n, final String expected) {

    // remove spaces and split the string
    final String[] expectedAsArray = expected.replaceAll("\\s+", "").split(",");
    // method under test
    final List<String> actual = new ArrayList<>();
    Brackets.generateParenthesisRecursive_1(n, (s -> actual.add(s)));
    // assertions
    Assertions.assertArrayEquals(expectedAsArray, actual.toArray(new String[actual.size()]));
  }

  @ParameterizedTest(name = "input: {0}")
  @MethodSource("testData")
  void generateParenthesesIterative(final int n, final String expected) {
    // remove spaces and split the string
    final String[] expectedAsArray = expected.replaceAll("\\s+", "").split(",");
    // method under test
    final List<String> actual = new ArrayList<>();
    Brackets.generateParenthesesIterative(n, (s -> actual.add(s)));
    // assertions
    Assertions.assertEquals(actual.size(), expectedAsArray.length);
    Arrays.stream(expectedAsArray).forEach(str -> Assertions.assertTrue(actual.contains(str)));
  }

  @ParameterizedTest(name = "input: {0}")
  @MethodSource("testData")
  void generateParenthesisRecursive_2(final int n, final String expected) {
    // remove spaces and split the string
    final String[] expectedAsArray = expected.replaceAll("\\s+", "").split(",");
    // method under test
    final List<String> actual = new ArrayList<>();
    Brackets.generateParenthesisRecursive_2(n, (s -> actual.add(s)));
    // assertions
    Assertions.assertEquals(actual.size(), expectedAsArray.length);
    Arrays.stream(expectedAsArray).forEach(str -> Assertions.assertTrue(actual.contains(str)));
  }

  private static Stream<Arguments> testData() {
    return Stream.of(
        Arguments.arguments(1, "()"),
        Arguments.arguments(2, "(()), ()()"),
        Arguments.arguments(3, "((())), (()()), (())(), ()(()), ()()()"),
        Arguments.arguments(
            4,
            "(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()"),
        Arguments.arguments(
            5,
            "((((())))), (((()()))), (((())())), (((()))()), (((())))(), ((()(()))), ((()()())), ((()())()), ((()()))(), ((())(())), ((())()()), ((())())(), ((()))(()), ((()))()(), (()((()))), (()(()())), (()(())()), (()(()))(), (()()(())), (()()()()), (()()())(), (()())(()), (()())()(), (())((())), (())(()()), (())(())(), (())()(()), (())()()(), ()(((()))), ()((()())), ()((())()), ()((()))(), ()(()(())), ()(()()()), ()(()())(), ()(())(()), ()(())()(), ()()((())), ()()(()()), ()()(())(), ()()()(()), ()()()()()"));
  }
}

// (())()
// ()(())
