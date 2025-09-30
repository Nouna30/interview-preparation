package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class P435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] arr) -> arr[0])
                .thenComparingInt((int[] arr) -> arr[1]));

        int length = intervals.length;
        int end = intervals[0][1];

        int count = 0;

        for (int i = 1; i < length; i++) {
            if (intervals[i][0] > end) {
                end = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }

}
