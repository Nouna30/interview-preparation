package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestMostFrequentPrefix {

    // https://www.algoexpert.io/questions/longest-most-frequent-prefix
    //
    // NOTES:
    // Generate a trie with each node having a freq, denotes the number of times we visited
    // that node.
    // Now do a DFS, and at any point when node.freq < parent.freq -> the common prefix
    // ends at the parent node.
    // Keep the character as one of the fields - east to accumulate while DFS, and use a buffer
    // to generate the prefix and also backtrack.

    public String longestMostFrequentPrefix(String[] strings) {
        Trie trie = new Trie();
        String longestString = "";
        for (String string : strings) {
            if (string.length() > longestString.length()) {
                longestString = string;
            }
            trie.add(string);
        }

        String longestPrefix = trie.findLongestMostFreqPrefix();
        return longestPrefix != null ? longestPrefix : longestString;
    }

    private static class Trie {
        final Node root = new Node('\0');

        void add(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(ch, Node::new);
                curr.freq++;
            }
        }

        String findLongestMostFreqPrefix() {
            String[] prefixRef = new String[1];
            int[] freqRef = new int[1];
            StringBuilder sb = new StringBuilder();
            for (Node node : root.children.values()) {
                dfs(root, node, sb, freqRef, prefixRef);
            }

            return prefixRef[0];
        }

        private void dfs(Node parent, Node current, StringBuilder sb, int[] freqRef,
                         String[] prefixRef) {
            if (current == null || parent.freq > current.freq) {
                if (parent.freq > freqRef[0]) {
                    freqRef[0] = parent.freq;
                    prefixRef[0] = sb.toString();
                } else if (parent.freq == freqRef[0] && sb.length() > prefixRef[0].length()) {
                    prefixRef[0] = sb.toString();
                }
                return;
            }

            sb.append(current.ch);

            for (Node child : current.children.values()) {
                dfs(current, child, sb, freqRef, prefixRef);
            }

            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private static class Node {
        final char ch;
        final Map<Character, Node> children = new HashMap<>();
        int freq;

        public Node(char ch) {
            this.ch = ch;
        }
    }

}
