```
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
```
class Solution:
    def validPalindrome(self, s: str) -> bool:
        l,r = 0,len(s)-1
        def sub(s):
            l,r = 0 ,len(s)-1
            while l<r:
                if s[l] !=s[r]:
                    return False
                l+=1
                r-=1
            return True
        while l<r:
            if s[l] != s[r]:
                return sub(s[l+1:r+1]) or sub(s[l:r])
            l+=1
            r-=1
        return True
                