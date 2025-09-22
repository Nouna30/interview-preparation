package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class MinimumWaitingTime {

    // https://www.algoexpert.io/questions/minimum-waiting-time
    //
    // NOTES:
    // Sort the array in natural order.
    // Wait time for 0 = 0
    // Wait time for 1 = wait time[0] + execution time [0]
    // Wait time of i = wait time[i - 1] + execution time [i - 1]

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        int prevWaitingTime = 0;

        for (int i = 1; i < queries.length; i++) {
            prevWaitingTime = prevWaitingTime + queries[i - 1];
            totalWaitingTime += prevWaitingTime;
        }

        return totalWaitingTime;
    }

}
