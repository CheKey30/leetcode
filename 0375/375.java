/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
*/

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>0;j--){
                int min = Integer.MAX_VALUE;
                for(int k=j+1;k<i;k++){
                    min = Math.min(min,k+Math.max(dp[j][k-1],dp[k+1][i]));
                }
                dp[j][i] = (j+1==i?j:min);
            }
        }
        return dp[1][n];
    }
}