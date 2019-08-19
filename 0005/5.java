/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        char[] tmp = s.toCharArray();
        char[] arr = new char[tmp.length*2+1];
        arr[0] = '#';
        int j =1;
        for(int i=0;i<tmp.length;i++){
            arr[j++]=tmp[i];
            arr[j++]='#';
        }
        int[] res = new int[2];
        int[] dp = new int[arr.length];
        int maxright =0;
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            if (i<maxright){
                dp[i] = Math.min(dp[2*idx-i],maxright-i);
            }else{
                dp[i]=1;
            }
            while(i-dp[i]>=0 && i+dp[i]<arr.length && arr[i-dp[i]] == arr[i+dp[i]]){
                dp[i]++;
            }
            if(dp[i]+i>maxright){
                maxright = dp[i]+i-1;
                idx = i;
            }
            if(dp[i]>res[1]){
                res[0] = i;
                res[1] = dp[i];
            }
        }
        String str = "";
        for(int i=res[0]-res[1]+1; i<=res[0]+res[1]-1; i++){
            if(arr[i] !='#'){
                str+=arr[i];
            }
        }
        return str;
    }
}
