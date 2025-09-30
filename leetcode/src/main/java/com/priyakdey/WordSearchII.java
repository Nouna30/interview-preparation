package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Priyak Dey
 */
public class WordSearchII {

    // #212. Word Search II
    // https://leetcode.com/problems/word-search-ii/description/
    //
    // NOTES:
    // Build the trie out of all the words.
    // Then iterate over row * col, and for each, do a DFS on the trie.
    // Do fail fast, if you find any word, mark that word void in the trie,
    // do avoid duplicates.

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;

        Trie trie = new Trie();
        trie.addAll(words);

        List<String> acc = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                trie.findWords(board, row, col, rows, cols, acc);
            }
        }

        return acc;
    }

    private static class Trie {
        private final Node root;

        private final StringBuilder sb = new StringBuilder();
        private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        private Trie() {
            root = new Node('\0');
        }

        private void addAll(String[] words) {
            Stream.of(words).forEach(this::add);
        }

        private void add(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(ch, Node::new);
            }
            curr.end = true;
        }

        private void findWords(char[][] board, int row, int col, int rows, int cols,
                               List<String> acc) {
            for (Node child : root.children.values()) {
                dfs(board, row, col, rows, cols, child, acc);
            }
            sb.setLength(0);
        }

        private void dfs(char[][] board, int row, int col, int rows, int cols, Node curr,
                         List<String> acc) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) return;
            if (board[row][col] != curr.ch) return;

            char ch = board[row][col];
            sb.append(curr.ch);
            board[row][col] = '\0';

            if (curr.end) {
                acc.add(sb.toString());
                curr.end = false;       // demark word, to avoid duplicates
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                for (Node child : curr.children.values()) {
                    dfs(board, nextRow, nextCol, rows, cols, child, acc);
                }
            }

            board[row][col] = ch;
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private static class Node {
        private final char ch;
        private final Map<Character, Node> children;
        boolean end;

        private Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }

}
