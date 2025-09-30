package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class SimplifyPath {

    // #71. Simplify Path
    // https://leetcode.com/problems/simplify-path/description
    //
    // NOTES:
    // Use a stack to iterate over the tokens and then generate the canonical path.

    public String simplifyPath(String path) {
        int length = path.length();
        Deque<String> stack = new ArrayDeque<>();
        int curr = 0;

        while (curr < length) {
            if (path.charAt(curr) == '/') {
                curr++;
            } else {
                int start = curr;
                while (curr < length && path.charAt(curr) != '/') {
                    curr++;
                }

                String token = path.substring(start, curr);

                switch (token) {
                    case ".":
                        break;
                    case "..":
                        if (!stack.isEmpty()) stack.poll();
                        break;
                    default:
                        stack.push(token);
                        break;
                }
            }
        }

        int size = stack.size();
        String[] canonicalPath = new String[size];
        int cursor = size - 1;
        while (!stack.isEmpty()) {
            canonicalPath[cursor--] = stack.poll();
        }

        return "/" + String.join("/", canonicalPath);
    }

}
