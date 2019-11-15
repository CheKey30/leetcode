/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        String common = strs[0];
        for(String x:strs){
            common = findCommon(x,common);
        }
        return common;
    }
    
    public String findCommon(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int l=0;
        int r=0;
        while(l<s1.length() && r<s2.length()){
            if(s1.charAt(l)==s2.charAt(r)){
                sb.append(s2.charAt(r));
                l++;
                r++;
            }else{
                break;
            }
        }
        
        return sb.toString();
    }
}