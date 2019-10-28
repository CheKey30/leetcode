/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1){
            return n;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 1;
        map.put(s.charAt(0),0);
        int max = Integer.MIN_VALUE;
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l,map.get(s.charAt(r))+1);
            }
            map.put(s.charAt(r),r);
            max = Math.max(r-l+1,max);
            r++;
        }
        
        return max;
    }
}