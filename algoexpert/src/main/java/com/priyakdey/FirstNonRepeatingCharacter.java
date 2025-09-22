package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FirstNonRepeatingCharacter {

    // https://www.algoexpert.io/questions/first-non-repeating-character
    //
    // NOTES:
    // Capture the frequency of each character.
    // Iterate over the original string, and find the first character, for which
    // freq == 1.

    public int firstNonRepeatingCharacter(String string) {
        int[] counter = new int[26];
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            counter[ch - 'a']++;
        }

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (counter[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
