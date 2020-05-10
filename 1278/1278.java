/*
You are given a string s containing lowercase letters and an integer k. You need to :

First, change some characters of s to other lowercase English letters.
Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
Return the minimal number of characters that you need to change to divide the string.

 

Example 1:

Input: s = "abc", k = 2
Output: 1
Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
Example 2:

Input: s = "aabbc", k = 3
Output: 0
Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
Example 3:

Input: s = "leetcode", k = 8
Output: 0
*/

class Solution {
    public int palindromePartition(String s, int k) {
        int m = s.length();
        int[][] cost = new int[m][m];
        for(int l=2;l<=m;l++){
            for(int i=0;i<m;i++){
                int j = i+l-1;
                if(j>=m){
                    continue;
                }else{
                    cost[i][j] = (s.charAt(i)!=s.charAt(j)?1:0)+cost[i+1][j-1];
                }
            }
        }
        int[][] dp = new int[m][k+1];
        for(int i=0;i<m;i++){
            dp[i][1] = cost[0][i];
            for(int p=2;p<=k;p++){
                dp[i][p] = Integer.MAX_VALUE/2;
                for(int j=0;j<i;j++){
                    dp[i][p] = Math.min(dp[j][p-1]+cost[j+1][i],dp[i][p]);
                }
            }
        }
        return dp[m-1][k];
    }
}