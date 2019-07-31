```
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
```
class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        start,end = 0 ,len(s)-1
        while start<end:
            tmp = s[start]
            s[start] = s[end]
            s[end] = tmp
            start+=1
            end-=1
        start = end = 0
        for i in range(len(s)):
            if s[i] != " ":
                end = i
            else:
                s[start:end+1] = s[start:end+1][::-1]
                start = end = i+1
        s[start:end+1] = s[start:end+1][::-1]
        