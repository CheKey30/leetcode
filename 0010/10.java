/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
*/

class Solution {
    public boolean isMatch(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int j=1;j<=l2;j++){
            if(s2.charAt(j-1)=='*' && dp[0][j-2]){
                dp[0][j] = true;
            }
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s2.charAt(j-1)=='*'){
                    if(s2.charAt(j-2)!='.' && s2.charAt(j-2) !=s1.charAt(i-1)){
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i-1][j] || dp[i][j-2] || dp[i][j-1];
                    }
                }
            }
        }
        return dp[l1][l2];
    }
}