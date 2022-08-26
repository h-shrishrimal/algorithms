package dev.letsdebug.dp.brackets;

import java.util.function.Consumer;

public interface IBrackets {

    /**
     * Print all combinations of balanced parentheses
     * @param n total opening parentheses
     * @param cb callback to be called when a valid sequence is generated
     */
     void balancedParentheses(final int n, final Consumer<String> cb);


}
