package dev.letsdebug.dp.brackets;

import java.util.function.Consumer;

/**
 * Print all combinations of balanced parentheses.
 * This implementation uses iterative approach
 *
 * @author Harshad S
 */
public class BracketsIterative implements IBrackets {

  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening
   * brackets. This implementation is without recursion.
   *
   * @param n total opening brackets
   * @param cb callback to be called when a valid sequence is reached.
   */
  @Override
  public void balancedParentheses(int n, Consumer<String> cb) {
    // start with [((()))]
    // Start with the lexicographically smallest string.
    int N = 2 * n;
    char[] s = new char[N];
    for (int i = 0; i < n; i++) s[i] = '(';
    for (int i = n; i < N; i++) s[i] = ')';

    while (true) {
      cb.accept(String.valueOf(s));
      int openCount = 0, closedCount = 0; // open and close count

      // start from right to left
      for (int i = N - 1; i >= 0; i--) {
        if (i == 0) return; // exit condition.
        if (s[i] == ')') closedCount += 1;
        if (s[i] == '(') {
          openCount += 1;
          if (closedCount > openCount) {
            s[i] = ')'; // flipped s[i] from ( to )
            /* we just flipped s[i] from ( to )
            now we need to replace (starting from i+1) to the end of array
            with the smallest lexicographic suffix. Which are openCount opening
            and closedCount -1 closing parenthesis.
            (we already placed one closing
             parenthesis in the string so c - 1 left to place) */
            fillArray(s, i + 1, i + 1 + openCount, '(');
            fillArray(s, i + 1 + openCount, N, ')');
            break;
          }
        }
      }
    }
  }

  /**
   * fill {@code arr} with {@code s} from index {@code startIdx} to {@code endIdx} (exclusive)
   *
   * @param arr array to fill
   * @param startIdx start index
   * @param endIdx end index (exclusive)
   * @param s char to insert.
   */
  private static void fillArray(char[] arr, int startIdx, int endIdx, char s) {
    for (int i = startIdx; i < endIdx; i++) arr[i] = s;
  }
}
