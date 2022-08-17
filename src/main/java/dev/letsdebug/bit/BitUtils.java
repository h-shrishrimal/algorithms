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
   * get the {@code i } bit of {@code num}
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
   * set the {@code i } bit of {@code num}
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
   * clear the {@code i } bit in {@code num}
   *
   * @param num
   * @param i
   * @return
   */
  public static int clearIthBit(int num, int i) {
    // set all bits to 0 expect i bit and then invert all the bits
    int mask = ~(1 << i);
    return (num & mask);
  }

public static int updateIthBit(int num, int i, int bit) {
  // Clear the bit at the given position and add the resultant bit to the result.
  // Create a mask and perform an AND operation with the result.
  // Perform Binary OR operation with the mask we have created and perform the right shift
  // operation with the value to be updated at the index.
  int mask = clearIthBit(num, i);
  return mask | (bit << i);
}
}
