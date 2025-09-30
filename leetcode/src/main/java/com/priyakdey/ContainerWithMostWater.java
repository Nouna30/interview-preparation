package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ContainerWithMostWater {

    // #11. Container With Most Water
    // https://leetcode.com/problems/container-with-most-water/description
    //
    // NOTES:
    // Take a left and right pointer, measure the area, move the pointer inwards whose height
    // is less.

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int boundingHeight = Math.min(height[left], height[right]);
            int area = boundingHeight * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
