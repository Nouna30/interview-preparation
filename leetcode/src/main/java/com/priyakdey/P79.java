package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P79 {

    // #79. Word Search
    // https://leetcode.com/problems/word-search/description
    //
    // NOTES:
    // Iterates over each cell as a possible starting point and
    // recursively explores all four directions (up, down, left, right).
    // Marks visited cells temporarily to avoid revisiting in the same path.
    // Use Backtracking to ensure all paths are explored.

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (exists(board, row, col, rows, cols, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean exists(char[][] board, int row, int col, int rows, int cols, String word, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;

        if (board[row][col] != word.charAt(index)) return false;

        char ch = board[row][col];
        board[row][col] = '\0';

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (exists(board, newRow, newCol, rows, cols, word, index + 1)) {
                board[row][col] = ch;
                return true;
            }
        }

        board[row][col] = ch;
        return false;
    }

}
