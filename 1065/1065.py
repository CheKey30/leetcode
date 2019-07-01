```
Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j] is in the list of words.

 

Example 1:

Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
Output: [[3,7],[9,13],[10,17]]
Example 2:

Input: text = "ababa", words = ["aba","ab"]
Output: [[0,1],[0,2],[2,3],[2,4]]
Explanation: 
Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
```
class Solution:
    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        res = []
        for i in range(len(text)):
            for w in words:
                j = i+len(w)-1
                if j<len(text) and text[i:j+1]==w:
                    res.append([i,j])
        res.sort()
        return res