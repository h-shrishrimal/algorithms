package dev.letsdebug.dp;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Print all combinations of balanced parentheses
 *
 * @author Harshad S
 */
public final class Brackets {

  /**
   * ways in which brackets can be arranged, if the closing brackets should ever exceed opening
   * brackets.
   *
   * @param n total opening brackets
   * @param cb callback to be called when a valid sequence is reached.
   */
  public static void generateParenthesis(final int n, Consumer<String> cb) {
    generateParenthesis(n, 0, 0, "", cb);
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
  private static void generateParenthesis(
      final int n, int noOpen, int noClose, String output, Consumer<String> cb) {

    // base case
    // number of open and close brackets match, and they equal to n
    // then we have a valid combination
    if (noClose == noOpen && noOpen == n) {
      cb.accept(output);
      return;
    }

    // we can put an open bracket, only if it's less than n
    if (noOpen < n) generateParenthesis(n, noOpen + 1, noClose, output + '(', cb);

    // we can put closing bracket only if an opening bracket is already there
    if (noOpen > noClose) generateParenthesis(n, noOpen, noClose + 1, output + ')', cb);
  }
}
