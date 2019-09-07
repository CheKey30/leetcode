/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> out = new ArrayList<>();
        helper(s,res,out,0);
        return res;
    }
    
    public void helper(String s, List<List<String>> res, List<String> out, int start){
        if(start==s.length()){
            res.add(new ArrayList<>(out));
            return;
        }
        
        for(int i= start;i<s.length();i++){
            if(!isPalindrome(start,i,s)){
                continue;
            }
            out.add(s.substring(start,i+1));
            helper(s,res,out,i+1);
            out.remove(out.size()-1);
        }
    }
    
    public boolean isPalindrome(int start, int end, String s){
        char[] str = s.toCharArray();
        while(start<end){
            if(str[start]!=str[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}