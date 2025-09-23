package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NumberOfWaysToMakeChange {

    // https://www.algoexpert.io/questions/number-of-ways-to-make-change
    //
    // NOTES:
    // This is classic dp problem. Iterate over the denoms and remove from n.
    // Once n == 0, return 1, if it goes beyond 0, return 0

    public static int numberOfWaysToMakeChangeRec(int n, int[] denoms) {
        int length = denoms.length + 1;
        return numberOfWaysToMakeChangeRecInternal(n, 0, denoms,
                new Integer[n + 1][length + 1]);
    }

    private static int numberOfWaysToMakeChangeRecInternal(int n, int i, int[] denoms,
                                                           Integer[][] cache) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (cache[n][i] != null) return cache[n][i];

        int ways = 0;

        for (int j = i; j < denoms.length; j++) {
            ways += numberOfWaysToMakeChangeRecInternal(n - denoms[j], j, denoms, cache);
        }

        cache[n][i] = ways;
        return ways;
    }

}
