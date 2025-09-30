package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P2043 {

    // #2043: Simple Bank System
    // https://leetcode.com/problems/simple-bank-system/description
    //
    // NOTES:
    // This is a simple array manipulation with making sure always access account_no - 1

    private final long[] balance;
    private final int n;

    public P2043(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccountNumber(account1) || !isValidAccountNumber(account2)) return false;

        if (balance[account1 - 1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccountNumber(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccountNumber(account)) return false;
        if (balance[account - 1] < money) return false;
        balance[account - 1] -= money;
        return true;
    }

    private boolean isValidAccountNumber(int account) {
        return account >= 1 && account <= n;
    }

}
