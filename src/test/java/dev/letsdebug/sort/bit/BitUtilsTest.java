package dev.letsdebug.sort.bit;

import dev.letsdebug.bit.BitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BitUtilsTest {

  @ParameterizedTest(name = "input: {0}, expected: {1}")
  @CsvSource({
    "0,false",
    "1,true",
    "2,false",
    "3,true",
    "4,false",
    "5,true",
    "6,false",
    "7,true",
    "8,false",
    "9,true",
    "10,false",
    "-9,true",
    "-10,false",
  })
  void isOddTest(int input, boolean expected) {
    boolean actual = BitUtils.isOdd(input);
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "input: {0}, expected: {2}")
  @CsvSource({"10,0,0", "10,1,1", "10,2,0", "10,3,1", "-10,0,0", "-10,1,1", "-10,2,1", "-10,3,0"})
  void getIthBitTest(int num, int i, int expected) {
    int actual = BitUtils.getIthBit(num, i);
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "input: {0}, bit: {1}")
  @CsvSource({
    "10,0,1011",
    "10,1,1010",
    "10,2,1110",
    "10,3,1010",
    "-10,0,11111111111111111111111111110111",
    "-10,1,11111111111111111111111111110110",
    "-10,2,11111111111111111111111111110110",
    "-10,3,11111111111111111111111111111110"
  })
  void setIthBitTest(int num, int i, String expectedInBinary) {
    int actual = BitUtils.setIthBit(num, i);
    Assertions.assertEquals(expectedInBinary, Integer.toBinaryString(actual));
  }

  @ParameterizedTest(name = "input: {0}, bit: {1}")
  @CsvSource({
          "10,0,1010",
          "10,1,1000",
          "10,2,1010",
          "10,3,10",
          "-10,0,11111111111111111111111111110110",
          "-10,1,11111111111111111111111111110100",
          "-10,2,11111111111111111111111111110010",
          "-10,3,11111111111111111111111111110110"
  })
  void clearIthBitTest(int num, int i, String expectedInBinary) {
    int actual = BitUtils.clearIthBit(num, i);
    Assertions.assertEquals(expectedInBinary, Integer.toBinaryString(actual));
  }
}
