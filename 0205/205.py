```
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
```
class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dic,tmp = {},set()
        for i,c in enumerate(s):
            if c not in dic:
                if t[i] in tmp:
                    return False
                dic[c] = t[i]
                tmp.add(t[i])
            else:
                if dic[c] !=t[i]:
                    return False
        return True
