```
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
```
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp=[[0 for _ in range(n)] for _ in range(n)]
        for i in range(n-1,-1,-1):
            for j in range(i,n):
                if j==i:
                    dp[i][j]=1
                else:
                    if s[i]==s[j]:
                        dp[i][j] = 2+dp[i+1][j-1]
                    else:
                        dp[i][j] = max(dp[i][j-1],dp[i+1][j])
        return dp[0][n-1]