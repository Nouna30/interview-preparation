package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1052 {

    // #1052. Grumpy Bookstore Owner
    // https://leetcode.com/problems/grumpy-bookstore-owner/description
    //
    // NOTES:
    // Use prefix sums to efficiently calculate total customers and satisfied customers.
    // Dor each possible window of minutes, compute extra satisfied customers if owner is
    // not grumpy.
    // Return the maximum possible satisfied customers after applying the technique.
    // Time complexity: O(n), Space complexity: O(n)
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length = customers.length;
        int[] arr1 = new int[length + 1];
        int[] arr2 = new int[length + 1];


        for (int i = 0; i < length; i++) {
            arr1[i + 1] = arr1[i] + customers[i];
            arr2[i + 1] = arr2[i] + (grumpy[i] == 0 ? customers[i] : 0);
        }

        int total = arr2[length];

        int maxValue = 0;
        for (int i = minutes; i <= length; i++) {
            int value = total + (arr1[i] - arr1[i - minutes]) - (arr2[i] - arr2[i - minutes]);
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }

}
