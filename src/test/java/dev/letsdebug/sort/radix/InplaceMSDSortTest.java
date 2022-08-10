package dev.letsdebug.sort.radix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/** Junit test for MSD Radix Sort */
class InplaceMSDSortTest {

  /** Test for {@link InplaceMSD#sort(String[])} method. */
  @Test
  void msdSortTest() throws Exception {
    // copy the data
    String[] input = Arrays.copyOf(RadixUtils.SORTED_DATA, RadixUtils.SORTED_DATA.length);
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(Arrays.asList(input));
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, RadixUtils.SORTED_DATA);
    // method under test
    InplaceMSD.sort(input);
    Assertions.assertArrayEquals(input, RadixUtils.SORTED_DATA);
  }

  /** Test for {@link InplaceMSD#sort(String[])} method. */
  @Test
  void msdSortVariableLengthDataTest() throws Exception {
    // copy the data
    String[] input =
        Arrays.copyOf(
            RadixUtils.VARIABLE_LENGTH_SORTED_DATA, RadixUtils.VARIABLE_LENGTH_SORTED_DATA.length);
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(Arrays.asList(input));
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, RadixUtils.VARIABLE_LENGTH_SORTED_DATA);
    // method under test
    InplaceMSD.sort(input);
    Assertions.assertArrayEquals(input, RadixUtils.VARIABLE_LENGTH_SORTED_DATA);
  }
}
