package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P122 {

    // #122: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description
    //
    // NOTES:
    // Iterate over the array, if current price is >= buying price - do a tx.
    // Always reassign buy price to current price.

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price >= buyPrice) {
                maxProfit = maxProfit + (price - buyPrice);
            }
            buyPrice = price;
        }

        return maxProfit;
    }
}
