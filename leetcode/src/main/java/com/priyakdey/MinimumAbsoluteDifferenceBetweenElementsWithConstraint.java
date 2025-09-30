package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {

    // #2817. Minimum Absolute Difference Between Elements With Constraint
    // https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description
    //
    // NOTES:
    // Iterate from the index x, and push all elements in the range [0, current - x] into a
    // sorted list.
    // Find the greatest less than eq in the subarray of the nums[current].
    // This will help calculate the min diff.

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int minDiff = Integer.MAX_VALUE;
        int size = nums.size();
        List<Integer> subarray = new ArrayList<>(size - x);

        for (int i = x; i < size; i++) {
            addToList(subarray, nums.get(x - i));

            Integer value = nums.get(i);
            int index = findIndexOfGreatestLessThanEq(subarray, value);

            if (index != -1) {
                int diff = value - subarray.get(index);
                if (index + 1 < subarray.size()) {
                    diff = Math.min(diff, subarray.get(index + 1) - value);
                }

                minDiff = Math.min(minDiff, diff);
            } else {
                minDiff = Math.min(minDiff, subarray.getFirst() - value);
            }
        }

        return minDiff;
    }

    private void addToList(List<Integer> nums, int num) {
        if (nums.isEmpty()) {
            nums.add(num);
            return;
        }

        if (num <= nums.getFirst()) {
            nums.addFirst(num);
            return;
        }

        if (num >= nums.getLast()) {
            nums.add(num);
            return;
        }

        int left = 0, right = nums.size() - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        nums.add(index + 1, num);
    }

    private int findIndexOfGreatestLessThanEq(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

}
