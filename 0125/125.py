```
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
```
class Solution:
    def isPalindrome(self, s: str) -> bool:
        tmp = ""
        if not s:
            return True
        for i in range(len(s)):
            if (ord(s[i])<=122 and ord(s[i])>=97) or (ord(s[i])>=65 and ord(s[i])<=90) or (ord(s[i])<=57 and ord(s[i])>=48):
                tmp+=s[i]
        tmp = tmp.lower()
        l,r = 0 ,len(tmp)-1
        while l<r:
            if tmp[l] != tmp[r]:
                return False
            l+=1
            r-=1
        return True
        
      