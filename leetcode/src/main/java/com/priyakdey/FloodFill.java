package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FloodFill {

    // #733. Flood Fill
    // https://leetcode.com/problems/flood-fill/description
    //
    // NOTES:
    // Do a DFS from the starting cell.
    // Fail fast if cell is already the fill color or not the original color.


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int[][] copy = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy[row][col] = image[row][col];
            }
        }

        floodFill(copy, sr, sc, rows, cols, color, image[sr][sc]);
        return copy;
    }

    private void floodFill(int[][] image, int row, int col, int rows, int cols,
                           int color, int origColor) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        if (image[row][col] == color || image[row][col] != origColor) return;

        image[row][col] = color;

        floodFill(image, row + 1, col, rows, cols, color, origColor);
        floodFill(image, row - 1, col, rows, cols, color, origColor);
        floodFill(image, row, col + 1, rows, cols, color, origColor);
        floodFill(image, row, col - 1, rows, cols, color, origColor);
    }

}
