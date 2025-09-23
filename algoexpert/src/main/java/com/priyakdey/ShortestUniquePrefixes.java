package com.priyakdey;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Priyak Dey
 */
public class ShortestUniquePrefixes {

    // https://www.algoexpert.io/questions/shortest-unique-prefixes
    //
    // NOTES:
    // Create a trie with all words. Make sure each node keeps a track of freq - number of
    // times the node is visited.
    // Now when node.freq == 1, the substring [0, i] is the unique prefix for that string.

    public String[] shortestUniquePrefixes(String[] strings) {
        Trie trie = new Trie();
        trie.addAll(strings);

        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = trie.findUniquePrefix(strings[i]);
        }

        return result;
    }

    private static class Trie {
        private final Node root = new Node('\0');

        void addAll(String[] strings) {
            Stream.of(strings).forEach(this::add);
        }

        void add(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(ch, Node::new);
                curr.freq++;
            }
        }

        String findUniquePrefix(String word) {
            int i = 0;
            Node curr = root;
            while (i < word.length()) {
                curr = curr.children.get(word.charAt(i++));
                if (curr.freq == 1) break;
            }

            return word.substring(0, i + 1);
        }
    }

    private static class Node {
        final char ch;
        final Map<Character, Node> children = new HashMap<>();
        int freq;

        Node(char ch) {
            this.ch = ch;
        }
    }

}
