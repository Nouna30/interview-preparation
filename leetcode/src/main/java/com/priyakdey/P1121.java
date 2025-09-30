package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1121 {

    // #1121. Divide Array Into Increasing Sequences
    // https://leetcode.com/problems/divide-array-into-increasing-sequences/description
    //
     // NOTES:
    // To divide into subsequences, we need to have min m number of subsequences, where
    // m = max freq of an element in the array.
    // So now, lets be greedy and say we try and create m subsequences:
    // k * m <= total elements in original array.
    // If so, we can make it else not.

    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int length = nums.length;

        int maxFreq = 0;
        int i = 0;

        while (i < length) {
            int start = i;
            while (i < length && nums[i] == nums[start]) {
                i++;
            }
            int freq = i - start;
            maxFreq = Math.max(maxFreq, freq);
        }

        return nums.length >= k * maxFreq;
    }

}
