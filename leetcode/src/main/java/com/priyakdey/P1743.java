package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class P1743 {

    // #1743. Restore the Array From Adjacent Pairs
    // https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description
    //
    // NOTES:
    // Build a map of each number to its adjacent numbers using a HashMap and HashSet.
    // Find an endpoint (number with only one neighbor) to start reconstructing the array.
    // Iteratively add the next neighbor, removing the previous to avoid revisiting.
    // Assumes valid input with exactly one solution and two endpoints.
    // Time complexity O(n), Space complexity: O(n)

    public int[] restoreArray(int[][] adjacentPairs) {
        int length = adjacentPairs.length;
        int n = length + 1;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] adjacentPair : adjacentPairs) {
            int u = adjacentPair[0];
            int v = adjacentPair[1];
            map.computeIfAbsent(u, _ -> new HashSet<>()).add(v);
            map.computeIfAbsent(v, _ -> new HashSet<>()).add(u);
        }

        int entryPoint = -1;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                entryPoint = entry.getKey();
                break;
            }
        }


        int[] originalArr = new int[n];
        // assumption - always one entry point exists - valid input
        originalArr[0] = entryPoint;

        for (int i = 1; i < n; i++) {
            int value = originalArr[i - 1];
            Set<Integer> set = map.get(value);
            int nextValue = set.stream().findFirst().get();

            map.get(nextValue).remove(value);

            // assumption - with valid input there needs to be only 1 entry now
            originalArr[i] = nextValue;
        }

        return originalArr;
    }

}
