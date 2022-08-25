package dev.letsdebug.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Print all combinations of balanced parentheses
 *
 * @author Harshad S
 */
public final class Brackets {
  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening
   * brackets. This implementation uses recursion.
   *
   * @param n total opening brackets
   * @param cb callback to be called when a valid sequence is reached.
   */
  public static void generateParenthesisRecursive_1(final int n, Consumer<String> cb) {
    generateParenthesisRecursive_1(n, 0, 0, "", cb);
  }

  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening *
   * brackets.
   *
   * @param n total opening brackets
   * @param noOpen current open brackets printed
   * @param noClose current closed brackets printed
   * @param output holds a valid combination
   * @param cb callback to be called when a valid sequence is reached.
   */
  private static void generateParenthesisRecursive_1(
      final int n, int noOpen, int noClose, String output, Consumer<String> cb) {

    // base case
    // number of open and close brackets match, and they equal to n
    // then we have a valid combination
    if (noClose == noOpen && noOpen == n) {
      cb.accept(output);
      return;
    }

    // we can put an open bracket, only if it's less than n
    if (noOpen < n) generateParenthesisRecursive_1(n, noOpen + 1, noClose, output + '(', cb);

    // we can put closing bracket only if an opening bracket is already there
    if (noOpen > noClose) generateParenthesisRecursive_1(n, noOpen, noClose + 1, output + ')', cb);
  }
  // ----------------------------------

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

  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening
   * brackets. This implementation is without recursion.
   *
   * @param n total opening brackets
   * @param cb callback to be called when a valid sequence is reached.
   */
  public static void generateParenthesesIterative(final int n, Consumer<String> cb) {

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

  // ----------------------------------
  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening
   * brackets. This implementation uses recursion. In this implementation all-ways are collected
   * together in a collection.
   *
   * @param n total opening brackets
   * @param cb callback to be called when a valid sequence is reached.
   */
  public static void generateParenthesisRecursive_2(int n, Consumer<String> cb) {
    List<String> results = generateParenthesisRecursive_2(n);
    results.forEach((r -> cb.accept(r)));
  }

  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening *
   * brackets
   *
   * @param n number of opening brackets
   * @return all valid ways in which brackets of {@code n} can be arranaged
   */
  private static List<String> generateParenthesisRecursive_2(int n) {
    List<String> result = new ArrayList<>();
    if (n == 0) {
      String empty = "";
      result.add(empty);
    } else {
      for (int closure = 0; closure < n; closure++)
        for (String left : generateParenthesisRecursive_2(closure))
          for (String right : generateParenthesisRecursive_2(n - closure - 1))
            result.add("(" + left + ")" + right);
    }

    return result;
  }
}
