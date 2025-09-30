package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1166 {

    // #1166. Design File System
    // https://leetcode.com/problems/design-file-system/description
    //
    // NOTES:
    // Create a trie of paths to store the values.
    // This is space efficient but not so much on time.
    // If we want more time efficient, we can use a HashMap to store parents and values.

    private final Node root;

    public P1166() {
        root = Node.init("", -1);
    }

    public boolean createPath(String path, int value) {
        if (path.isEmpty() || path.equals("/")) return false;

        String[] parts = path.split("/");

        Node curr = root;

        for (int i = 1; i < parts.length - 1; i++) {
            String part = parts[i];
            if (part.equals("/")) continue;

            if (!curr.children.containsKey(part)) return false;
            curr = curr.children.get(part);
        }

        String lastPart = parts[parts.length - 1];
        if (curr.children.containsKey(lastPart)) return false;
        curr.children.put(lastPart, Node.init(lastPart, value));
        return true;
    }

    public int get(String path) {
        if (path.isEmpty() || path.equals("/")) return -1;

        String[] parts = path.split("/");
        Node curr = root;

        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.equals("/")) continue;
            curr = curr.children.get(part);
            if (curr == null) return -1;
        }

        return curr.value;
    }

    private record Node(String path, Map<String, Node> children, int value) {

        private static Node init(String path, int value) {
            return new Node(path, new HashMap<>(), value);
        }

    }

}
