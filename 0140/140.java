/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String,List<String>> map = new HashMap<>();
        return helper(map,s,wordDict);
    }
    
    public List<String> helper(HashMap<String,List<String>> map, String s, List<String> dict){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.equals("")){
            List<String> tmplist = new ArrayList<>();
            tmplist.add("");
            return tmplist;
        }
        List<String> res = new ArrayList<>();
        for(String x:dict){
            if(s.length()<x.length() || !s.substring(0,x.length()).equals(x)){
                continue;
            }
            List<String> tmp = helper(map,s.substring(x.length()),dict);
            for(String str:tmp){
                res.add(x+ ((str.equals(""))? "":" ") +str);
            }
        }
        map.put(s,res);
        return res;
    }
}