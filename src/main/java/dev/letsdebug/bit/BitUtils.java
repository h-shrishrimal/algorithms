package dev.letsdebug.bit;

/**
 * @author Harshad S
 */
public final class BitUtils {

  /**
   * Check if given number is odd or even.
   *
   * @param num input to check if it's odd or even
   * @return {@code true} if odd, {@code false} otherwise
   */
  public static boolean isOdd(int num) {
    // perform a bitwise &, if it's 1 then odd.
    // for an even number bitwise & with 1 will always give 0
    // check if last bit is 1 or 0
    return (num & 1) == 1;
  }

  /**
   * Check if {@code num} is power of 2
   *
   * @param num input to check
   * @return {@code true} if power of 2, {@code false} otherwise
   */
  public static boolean isPowerOf2(long num) {
    // if num is power of 2 its bit pattern will always be 1 followed by 0's
    return (num & (num - 1)) == 0;
  }

  /**
   * get the {@code i} bit of {@code num}
   *
   * @param num input
   * @param i bit to return
   * @return the ith bit of num
   */
  public static int getIthBit(int num, int i) {
    // set all bits to 0 expect i bit.
    int mask = 1 << i;
    return (num & mask) > 0 ? 1 : 0;
  }

  /**
   * set the {@code i} bit of {@code num}
   *
   * @param num input
   * @param i bit to set
   * @return number with the ith bit set
   */
  public static int setIthBit(int num, int i) {
    // set all bits to 0 expect i bit.
    int mask = 1 << i;
    return (num | mask);
  }

  /**
   * clear the {@code i} bit in {@code num}
   *
   * @param num input
   * @param i bit to clear
   * @return number with ith bit cleared
   */
  public static int clearIthBit(int num, int i) {
    // set all bits to 0 expect i bit and then invert all the bits
    int mask = ~(1 << i);
    return (num & mask);
  }

  /**
   * update the {@code i} bit in {@code num} with {@code bit}
   *
   * @param num input
   * @param i bit to update
   * @param bit new update bit (0 or 1)
   * @return number with {@code i} bit updated to {@code bit}
   */
  public static int updateIthBit(int num, int i, int bit) {
    // Clear the bit at the given position and add the resultant bit to the result.
    // Create a mask and perform an AND operation with the result.
    // Perform Binary OR operation with the mask we have created and perform the right shift
    // operation with the value to be updated at the index.
    int mask = clearIthBit(num, i);
    return mask | (bit << i);
  }

  /**
   * clear last {@code i} bits
   *
   * @param num input
   * @param i bits to start clearing from
   * @return new number with {@code i} bits cleared
   */
  public static int clearLastIbits(int num, int i) {
    int mask = (~0) << i;
    return (num & mask);
  }

  /**
   * clear bits in range {@code i} to {@code j}
   *
   * @param num input
   * @param i start range index
   * @param j end range index
   * @return number with bits {@code i} to {@code j} cleared
   */
  public static int clearBitsInRange(int num, int i, int j) {
    int mask_a = -1 << (j + 1);
    int mask_b = (1 << i) - 1;
    int mask = mask_a | mask_b;
    return num & mask;
  }

  /**
   * replace bits in range {@code i} to {@code j}
   *
   * @param num input
   * @param i start range index
   * @param j end range index
   * @param val new bits to replace
   * @return num with bits replaced with
   */
  public static int replaceBitsInRange(int num, int i, int j, int val) {
    int n = clearBitsInRange(num, i, j);
    int mask = val << i;
    return n | mask;
  }
}
