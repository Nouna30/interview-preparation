package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P20 {

    // #20. Valid Parentheses
    // https://leetcode.com/problems/valid-parentheses/description
    //
    // NOTES:
    // Use a stack to balance the brackets

    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
