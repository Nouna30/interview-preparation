package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class MergeSortedArray {

    // https://www.algoexpert.io/questions/merge-sorted-arrays
    //
    // NOTES:
    // Use min heap to keep track of all elements. Once popped, check if next element in the array
    // is present, if so, push it to the heap.
    // To do this, keep a track of element pushed - the row, col from which the element has been
    // picked.
    // Generally this question is based on LinkedList, so we can always check if next ref != null.
    // For this, we do need to keep track of indices.

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        int rows = arrays.size();
        PriorityQueue<Tuple> pq = new PriorityQueue<>(rows, Comparator.comparing(Tuple::value));

        int totalElements = 0;

        for (int row = 0; row < rows; row++) {
            List<Integer> integers = Objects.requireNonNull(arrays.get(row));
            int value = Objects.requireNonNull(integers.get(0));
            pq.offer(new Tuple(value, row, 0));
            totalElements += integers.size();
        }

        List<Integer> flattenArr = new ArrayList<>(totalElements);

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            flattenArr.add(tuple.value);

            int row = tuple.row;
            List<Integer> integers = arrays.get(row);
            int nextCol = tuple.col + 1;
            if (nextCol < integers.size()) {
                pq.offer(new Tuple(integers.get(nextCol), row, nextCol));
            }
        }

        return flattenArr;
    }

    private record Tuple(int value, int row, int col) {
    }

}
