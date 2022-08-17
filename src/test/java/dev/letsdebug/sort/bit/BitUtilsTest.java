package dev.letsdebug.sort.bit;

import dev.letsdebug.bit.BitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BitUtilsTest {

  @ParameterizedTest(name = "input: {0}, expected: {1}")
  @CsvSource({
    "2,true",
    "3,false",
    "4,true",
    "8,true",
    "16,true",
    "32,true",
    "64,true",
    "128,true",
    "256,true",
    "512,true",
    "1023,false",
    "1024,true",
    "1025,false",
    "2048,true",
    "4096,true",
    "8192,true",
    "1_125_899_906_842_624,true"
  })
  void isPowerOf2Test(long input, boolean expected) {
    boolean actual = BitUtils.isPowerOf2(input);
    Assertions.assertEquals(expected, actual);
  }

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

  @ParameterizedTest(name = "input: {0}, i: {1}")
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

  @ParameterizedTest(name = "input: {0}, i: {1}, val: {2}")
  @CsvSource({"10,0,1,1011", "10,0,0,1010", "10,1,0,1000", "10,1,1,1010"})
  void updateIthBitTest(int num, int i, int bit, String expectedInBinary) {
    int actual = BitUtils.updateIthBit(num, i, bit);
    Assertions.assertEquals(expectedInBinary, Integer.toBinaryString(actual));
  }

  @ParameterizedTest(name = "input: {0}, i: {1}")
  @CsvSource({"15,1,1110", "15,2,1100", "15,3,1000", "15,4,0"})
  void clearLastIBitsTest(int num, int i, String expectedInBinary) {
    int actual = BitUtils.clearLastIbits(num, i);
    Assertions.assertEquals(expectedInBinary, Integer.toBinaryString(actual));
  }

  @ParameterizedTest(name = "input: {0}, i: {1}, j: {2}")
  @CsvSource({"15,0,1,1100", "15,2,3,11", "15,1,3,1", "15,0,3,0"})
  void clearBitsInRangeTest(int num, int i, int j, String expectedInBinary) {
    int actual = BitUtils.clearBitsInRange(num, i, j);
    Assertions.assertEquals(expectedInBinary, Integer.toBinaryString(actual));
  }

  @ParameterizedTest(name = "input: {0}, i: {1}, j: {2}")
  @CsvSource({"15,0,1,0,1100", "15,1,2,0,1001"})
  void replaceBitsInRangeTest(int num, int i, int j, int val, String expectedInBinary) {
    int actual = BitUtils.replaceBitsInRange(num, i, j, val);
    System.out.println("Integer.toBinaryString(actual) = " + Integer.toBinaryString(actual));
    Assertions.assertEquals(expectedInBinary, Integer.toBinaryString(actual));
  }
}
