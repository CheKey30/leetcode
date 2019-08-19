```
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
```
import copy
class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if not s or not words:
            return []
        res = []
        m = len(words)
        n = len(words[0])
        words_dict = {}
        for i in words:
            if i in words_dict:
                words_dict[i]+=1
            else:
                words_dict[i]=1
        for i in range(len(s)-m*n+1):
            wd = copy.deepcopy(words_dict)
            k = m
            j = i
            while k>0:
                tmp = s[j:j+n]
                if tmp not in wd or wd[tmp]<=0:
                    break
                wd[tmp]-=1
                k-=1
                j+=n
            if k==0:
                res.append(i)
        return res