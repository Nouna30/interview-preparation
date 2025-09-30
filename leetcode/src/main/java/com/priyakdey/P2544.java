package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P2544 {

    // #2544. Alternating Digit Sum
    // https://leetcode.com/problems/alternating-digit-sum/description
    //
    // NOTES:
    // Max number of int32 is 2147483647 = 10 digits
    // So we create an array of 10 (O(1) extra space theoretically) and store the digits from LSB
    // to MSB.
    // Then we start from MSB adding with a bias of 1 and keep flipping the bias from 1 to -1
    // and vice versa.

    public int alternateDigitSum(int n) {
        int[] digits = new int[10];
        int cursor = 0;
        while (n > 0) {
            digits[cursor++] = n % 10;
            n = n / 10;
        }

        int sum = 0;
        int bias = 1;
        for (int i = cursor - 1; i >= 0; i--) {
            sum += digits[i] * bias;
            bias *= -1;
        }

        return sum;
    }

}
