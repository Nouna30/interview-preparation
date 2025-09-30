package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class NumberOfFlowersInFullBloom {

    // #2251. Number of Flowers in Full Bloom
    // https://leetcode.com/problems/number-of-flowers-in-full-bloom/description
    //
    // NOTES:
    // Split flowers into start and end times.
    // Then for each person find the count of start times less than equal to the time.
    // Then for each person find the count of end times less than the time.
    // The diff in these counts are the number of flowers the person will see in full bloom.

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int flowersLength = flowers.length;
        int peopleLength = people.length;

        int[] startTimes = new int[flowersLength];
        int[] endTimes = new int[flowersLength];

        for (int i = 0; i < flowersLength; i++) {
            startTimes[i] = flowers[i][0];
            endTimes[i] = flowers[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int[] result = new int[peopleLength];

        for (int i = 0; i < peopleLength; i++) {
            int time = people[i];
            result[i] = countOfLtEq(startTimes, time) - countOfLt(endTimes, time);
        }

        return result;
    }

    private int countOfLtEq(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index + 1;
    }

    private int countOfLt(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index + 1;
    }

    public int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        int peopleLength = people.length;
        int[] result = new int[peopleLength];

        for (int i = 0; i < peopleLength; i++) {
            for (int[] flower : flowers) {
                if (people[i] >= flower[0] && people[i] <= flower[1]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

}
