package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P2021 {

    public int brightestPosition(int[][] lights) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int[] light : lights) {
            int x = light[0], dx = light[1];
            left  = Math.min(left, x - dx);
            right = Math.max(right, x + dx);
        }

        int length = right - left + 1;
        int zero = 0 - left;
        int[] arr = new int[length];

        for (int[] light : lights) {
            int x = light[0], dx = light[1];
            int position = zero + x;

            for (int i = position - dx; i <= position + dx; i++) {
                arr[i]++;
            }
        }

        int maxPosition = -1;
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i] > maxPosition) {
                maxPosition = arr[i];
                index = i;
            }
        }

        return zero - index;
    }

}
