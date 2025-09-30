package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class P253 {

    // #253. Meeting Rooms II
    // https://leetcode.com/problems/meeting-rooms-ii/description
    //
    // NOTES:
    // Separate into start and end times, track start and end.
    // Keep track of total and empty rooms.

    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            startTimes[i] = interval[0];
            endTimes[i] = interval[1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int total = 1;
        int empty = 0;

        int start = 1;
        int end = 0;

        while (start < length) {
            if (startTimes[start] < endTimes[end]) {
                if (empty == 0) {
                    total++;
                } else {
                    empty--;
                }
                start++;
            } else {
                empty++;
                end++;
            }
        }

        return total;
    }

}
