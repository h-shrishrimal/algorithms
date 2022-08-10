package dev.letsdebug.sort.radix;

import dev.letsdebug.sort.merge.BottomUpMergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

/** Junit test for LSD Radix Sort */
class LSDSortTest {

  /** Test for {@link LSDSort#sort(String[])} method. */
  @Test
  void lsdSortTest() throws Exception {
    // copy the data
    String[] input = Arrays.copyOf(RadixUtils.SORTED_DATA, RadixUtils.SORTED_DATA.length);
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(Arrays.asList(input));
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, RadixUtils.SORTED_DATA);
    // method under test
    LSDSort.sort(input);
    Assertions.assertArrayEquals(input, RadixUtils.SORTED_DATA);
  }

  /** Test for {@link LSDSort#sort(String[])} method. */
  @Test
  void lsdSortExceptionTest() {
    assertThrows(
        Exception.class,
        () -> {
          // method under test
          LSDSort.sort(new String[] {"a", "ab"});
        });
  }
}
