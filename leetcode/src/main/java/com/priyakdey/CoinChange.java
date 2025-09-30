package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CoinChange {

    // #322. Coin Change
    // https://leetcode.com/problems/coin-change/description/
    //
    // NOTES:
    // Iterate over the coins and do a DFS recursively down the tree as dp.
    // Use negative value to showcase if amount can be made or not.

    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[coins.length + 1][amount + 1];
        return coinChange(coins, 0, amount, cache);
    }

    private int coinChange(int[] coins, int index, int amount, Integer[][] cache) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (cache[index][amount] != null) return cache[index][amount];

        int minWays = -1;

        for (int i = index; i < coins.length; i++) {
            int ways = coinChange(coins, i, amount - coins[i], cache);
            if (ways >= 0) {
                ways = 1 + ways;
                if (minWays == -1) minWays = ways;
                else minWays = Math.min(minWays, ways);
            }
        }


        cache[index][amount] = minWays;
        return minWays;
    }

}
