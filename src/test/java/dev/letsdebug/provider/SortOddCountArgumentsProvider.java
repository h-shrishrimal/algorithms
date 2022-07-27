package dev.letsdebug.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortOddCountArgumentsProvider implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
      throws Exception {
    return Arrays.stream(DATA_ODD_COUNT)
        .map(
            input -> {
              int n = input.length;
              String[] data = new String[n];
              for (int i = 0; i < input.length; i++) data[i] = input[i];
              return Arguments.of(data, EXPECTED_OUTPUT);
            });
  }

  private static final String[] EXPECTED_OUTPUT = {"a", "b", "c", "d", "e"};

  private static final String[][] DATA_ODD_COUNT = {
    {"a", "b", "c", "d", "e"},
    {"b", "a", "c", "d", "e"},
    {"c", "a", "b", "d", "e"},
    {"a", "c", "b", "d", "e"},
    {"b", "c", "a", "d", "e"},
    {"c", "b", "a", "d", "e"},
    {"d", "b", "a", "c", "e"},
    {"b", "d", "a", "c", "e"},
    {"a", "d", "b", "c", "e"},
    {"d", "a", "b", "c", "e"},
    {"b", "a", "d", "c", "e"},
    {"a", "b", "d", "c", "e"},
    {"a", "c", "d", "b", "e"},
    {"c", "a", "d", "b", "e"},
    {"d", "a", "c", "b", "e"},
    {"a", "d", "c", "b", "e"},
    {"c", "d", "a", "b", "e"},
    {"d", "c", "a", "b", "e"},
    {"d", "c", "b", "a", "e"},
    {"c", "d", "b", "a", "e"},
    {"b", "d", "c", "a", "e"},
    {"d", "b", "c", "a", "e"},
    {"c", "b", "d", "a", "e"},
    {"b", "c", "d", "a", "e"},
    {"e", "c", "d", "a", "b"},
    {"c", "e", "d", "a", "b"},
    {"d", "e", "c", "a", "b"},
    {"e", "d", "c", "a", "b"},
    {"c", "d", "e", "a", "b"},
    {"d", "c", "e", "a", "b"},
    {"a", "c", "e", "d", "b"},
    {"c", "a", "e", "d", "b"},
    {"e", "a", "c", "d", "b"},
    {"a", "e", "c", "d", "b"},
    {"c", "e", "a", "d", "b"},
    {"e", "c", "a", "d", "b"},
    {"e", "d", "a", "c", "b"},
    {"d", "e", "a", "c", "b"},
    {"a", "e", "d", "c", "b"},
    {"e", "a", "d", "c", "b"},
    {"d", "a", "e", "c", "b"},
    {"a", "d", "e", "c", "b"},
    {"a", "d", "c", "e", "b"},
    {"d", "a", "c", "e", "b"},
    {"c", "a", "d", "e", "b"},
    {"a", "c", "d", "e", "b"},
    {"d", "c", "a", "e", "b"},
    {"c", "d", "a", "e", "b"},
    {"b", "d", "a", "e", "c"},
    {"d", "b", "a", "e", "c"},
    {"a", "b", "d", "e", "c"},
    {"b", "a", "d", "e", "c"},
    {"d", "a", "b", "e", "c"},
    {"a", "d", "b", "e", "c"},
    {"e", "d", "b", "a", "c"},
    {"d", "e", "b", "a", "c"},
    {"b", "e", "d", "a", "c"},
    {"e", "b", "d", "a", "c"},
    {"d", "b", "e", "a", "c"},
    {"b", "d", "e", "a", "c"},
    {"b", "a", "e", "d", "c"},
    {"a", "b", "e", "d", "c"},
    {"e", "b", "a", "d", "c"},
    {"b", "e", "a", "d", "c"},
    {"a", "e", "b", "d", "c"},
    {"e", "a", "b", "d", "c"},
    {"e", "a", "d", "b", "c"},
    {"a", "e", "d", "b", "c"},
    {"d", "e", "a", "b", "c"},
    {"e", "d", "a", "b", "c"},
    {"a", "d", "e", "b", "c"},
    {"d", "a", "e", "b", "c"},
    {"c", "a", "e", "b", "d"},
    {"a", "c", "e", "b", "d"},
    {"e", "c", "a", "b", "d"},
    {"c", "e", "a", "b", "d"},
    {"a", "e", "c", "b", "d"},
    {"e", "a", "c", "b", "d"},
    {"b", "a", "c", "e", "d"},
    {"a", "b", "c", "e", "d"},
    {"c", "b", "a", "e", "d"},
    {"b", "c", "a", "e", "d"},
    {"a", "c", "b", "e", "d"},
    {"c", "a", "b", "e", "d"},
    {"c", "e", "b", "a", "d"},
    {"e", "c", "b", "a", "d"},
    {"b", "c", "e", "a", "d"},
    {"c", "b", "e", "a", "d"},
    {"e", "b", "c", "a", "d"},
    {"b", "e", "c", "a", "d"},
    {"b", "e", "a", "c", "d"},
    {"e", "b", "a", "c", "d"},
    {"a", "b", "e", "c", "d"},
    {"b", "a", "e", "c", "d"},
    {"e", "a", "b", "c", "d"},
    {"a", "e", "b", "c", "d"},
    {"d", "e", "b", "c", "a"},
    {"e", "d", "b", "c", "a"},
    {"b", "d", "e", "c", "a"},
    {"d", "b", "e", "c", "a"},
    {"e", "b", "d", "c", "a"},
    {"b", "e", "d", "c", "a"},
    {"c", "e", "d", "b", "a"},
    {"e", "c", "d", "b", "a"},
    {"d", "c", "e", "b", "a"},
    {"c", "d", "e", "b", "a"},
    {"e", "d", "c", "b", "a"},
    {"d", "e", "c", "b", "a"},
    {"d", "b", "c", "e", "a"},
    {"b", "d", "c", "e", "a"},
    {"c", "d", "b", "e", "a"},
    {"d", "c", "b", "e", "a"},
    {"b", "c", "d", "e", "a"},
    {"c", "b", "d", "e", "a"},
    {"c", "b", "e", "d", "a"},
    {"b", "c", "e", "d", "a"},
    {"e", "c", "b", "d", "a"},
    {"c", "e", "b", "d", "a"},
    {"b", "e", "c", "d", "a"},
    {"e", "b", "c", "d", "a"},
  };
}
