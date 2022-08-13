package dev.letsdebug.sort.radix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** Junit test for MSD Radix Sort */
class ThreadedMSDSortTest {

  /** Test for {@link ThreadedMSDSort#sort(String[])} method. */
  @Test
  void sortTest() throws Exception {
    // copy the data
    String[] input = Arrays.copyOf(RadixUtils.SORTED_DATA, RadixUtils.SORTED_DATA.length);
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(Arrays.asList(input));
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, RadixUtils.SORTED_DATA);
    // method under test
    ThreadedMSDSort.sort(input);
    Assertions.assertArrayEquals(input, RadixUtils.SORTED_DATA);
  }

  /** Test for {@link ThreadedMSDSort#sort(String[])} method. */
  @Test
  void largeCollectionSortTest() throws Exception {
    // read the file
    List<String> dataList =
        Files.readAllLines(Paths.get("src", "test", "resources", "words_alpha.txt"));
    // sort the data using in-build sort
    Collections.sort(dataList);
    // copy the data
    List<String> inputList = dataList.stream().collect(Collectors.toList());
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(inputList);
    // list to array
    String[] input = inputList.toArray(String[]::new);
    String[] expected = dataList.toArray(String[]::new);
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, expected);
    // method under test
    ThreadedMSDSort.sort(input);
    Assertions.assertArrayEquals(input, expected);
  }
}
