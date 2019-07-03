```
For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
```
class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        
        for i in range(len(str1),0,-1):
            if len(str1)%i==0 and len(str2)%i==0 and str1[0:i]==str2[0:i]:
                return str1[0:i]
        return ""