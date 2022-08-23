package dev.letsdebug.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class BracketsTest {

  @ParameterizedTest(name = "input: {0}")
  @CsvSource(
      value = {
        "1|()",
        "2|(()), ()()",
        "3|((())), (()()), (())(), ()(()), ()()()",
        "4|(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()",
        "5|((((())))), (((()()))), (((())())), (((()))()), (((())))(), ((()(()))), ((()()())), ((()())()), ((()()))(), ((())(())), ((())()()), ((())())(), ((()))(()), ((()))()(), (()((()))), (()(()())), (()(())()), (()(()))(), (()()(())), (()()()()), (()()())(), (()())(()), (()())()(), (())((())), (())(()()), (())(())(), (())()(()), (())()()(), ()(((()))), ()((()())), ()((())()), ()((()))(), ()(()(())), ()(()()()), ()(()())(), ()(())(()), ()(())()(), ()()((())), ()()(()()), ()()(())(), ()()()(()), ()()()()()"
      },
      delimiter = '|')
  void generateParenthesis(final int n, final String expected) {

    // remove spaces and split the string
    final String[] expectedAsArray = expected.replaceAll("\\s+", "").split(",");
    // method under test
    final List<String> actual = new ArrayList<>();
    Brackets.generateParenthesis(n, (s -> actual.add(s)));
    // assertions
    Assertions.assertArrayEquals(expectedAsArray, actual.toArray(new String[actual.size()]));
  }
}
