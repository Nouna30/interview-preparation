package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ValidTriangleNumber {

    // #611. Valid Triangle Number
    // https://leetcode.com/problems/valid-triangle-number/description/
    //
    // NOTES:
    // Sort the array, use two pointers and then run a binary search to find the spot
    // where nums[i] + nums[j] > nums[mid].
    // Find the rightmost number which satisfies this condition.
    // All numbers from [j + 1, index] can make a triplet with (i, j) pair.

    public int triangleNumber(int[] nums) {
        int length = nums.length;
        int triplets = 0;

        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                int left = j + 1, right = length - 1;
                int index = -1;
                int sum = nums[i] + nums[j];
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < sum) {
                        index = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (index != -1) {
                    triplets += index - (j + 1) + 1;
                }
            }
        }

        return triplets;
    }

}
