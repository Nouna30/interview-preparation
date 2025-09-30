package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NumberOfAdjacentElementsWithTheSameColor {

    // 2672. Number of Adjacent Elements With the Same Color
    // https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/description
    //
    // NOTES:
    // Maintain an array of current colors array of length n.
    // (I do n + 2, to avoid left and right bounds check)
    // For each query:
    //  - Preserve the current color.
    //  - Then get the color on the left and right
    //  - if current color is not zero, check if current color is same as left/right -
    //      decrement count accordingly
    //  - then update the colors array
    //  - check left and right colors, if same increment count accordingly.


    public int[] colorTheArray(int n, int[][] queries) {
        int length = queries.length;
        int[] colors = new int[n + 2];      // 2 extra cells on each side to avoid bounds check

        int count = 0;
        int[] counts = new int[length];

        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int index = query[0] + 1;       // offset by 1 to make it 1-indexed
            int color = query[1];

            int currColor = colors[index];
            int leftColor = colors[index - 1];
            int rightColor = colors[index + 1];

            if (currColor != 0) {
                if (currColor == leftColor) count--;
                if (currColor == rightColor) count--;
            }

            colors[index] = color;
            if (color == leftColor) count++;
            if (color == rightColor) count++;

            counts[i] = count;
        }

        return counts;
    }

}
