/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if(l1+l2 != l3){
            return false;
        }
        if(l1==0){
            return s2.equals(s3);
        }
        if(l2==0){
            return s1.equals(s3);
        }
        boolean[][] dp = new boolean[l1+1][l2+1];
        for(int i=1;i<=l3;i++){
            if(i<=l2){
                dp[0][i] = s2.substring(0,i).equals(s3.substring(0,i));
            }
            if(i<=l1){
                dp[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
            }
        }
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                int k = i+j;
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(k-1)) || (dp[i][j-1] && s3.charAt(k-1)==s2.charAt(j-1));
            }
        }
        
        return dp[l1][l2];
    }
}