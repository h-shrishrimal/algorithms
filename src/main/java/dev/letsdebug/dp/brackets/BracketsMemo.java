package dev.letsdebug.dp.brackets;

import java.util.*;
import java.util.function.Consumer;

public class BracketsMemo implements IBrackets {

  private Map<Integer, List<String>> table;

  public BracketsMemo() {
    // put the first entry for n = 0;
    List<String> result = new ArrayList<>();
    result.add("");
    table = new HashMap<>();
    table.put(0, result);
  }

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
    if (table.get(n) != null) {
      return table.get(n);
    }
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
    table.put(n, result);
    return result;
  }
}
