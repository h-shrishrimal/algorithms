package dev.letsdebug.dp.brackets;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Print all combinations of balanced parentheses. This implementation uses recursion without
 * memoization
 *
 * @author Harshad S
 */
public class BracketsWithoutMemo implements IBrackets {

  @Override
  public void balancedParentheses(int n, Consumer<String> cb) {
    List<String> results = generateParenthesis(n);
    results.forEach((r -> cb.accept(r)));
  }

  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening *
   * brackets
   *
   * @param n number of opening brackets
   * @return all valid ways in which brackets of {@code n} can be arranaged
   */
  private List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n == 0) {
      String empty = "";
      result.add(empty);
    } else {
      for (int closure = 0; closure < n; closure++)
        for (String left : generateParenthesis(closure))
          for (String right : generateParenthesis(n - closure - 1))
            result.add("(" + left + ")" + right);
    }

    return result;
  }
}
