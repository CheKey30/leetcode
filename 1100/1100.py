```
Given a string S, return the number of substrings of length K with no repeated characters.

 

Example 1:

Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation: 
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
Example 2:

Input: S = "home", K = 5
Output: 0
Explanation: 
Notice K can be larger than the length of S. In this case is not possible to find any substring.
 

Note:

1 <= S.length <= 10^4
All characters of S are lowercase English letters.
1 <= K <= 10^4
```
class Solution:
    def numKLenSubstrNoRepeats(self, S: str, K: int) -> int:
        if not S or K > len(S):
            return 0
        
        pos = {}
        cnt, j = 0, 0
        for i, c in enumerate(S):
            if c in pos and pos[c] >= j:
                j = pos[c] + 1
            pos[c] = i
            if i - j + 1 == K:
                cnt += 1 
                j += 1
        
        return cnt