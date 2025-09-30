package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P2169 {

    // #2169. Count Operations to Obtain Zero
    // https://leetcode.com/problems/count-operations-to-obtain-zero/description
    //
    // NOTES:
    // Simulate till one of the num is 0

    public int countOperations(int num1, int num2) {
        int count = 0;

        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            count++;
        }

        return count;
    }

}
