/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=amount;i++){
            min = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=-1){
                    min = Math.min(dp[i-coins[j]],min);
                }
            }
            dp[i] = (min==Integer.MAX_VALUE?-1:min+1);
        }
        
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}