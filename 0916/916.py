```
We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.

 

Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
```
class Solution:
    def wordSubsets(self, A: List[str], B: List[str]) -> List[str]:
        b = dict()
        for i in B:
            for j in range(len(i)):
                if i[j] in b:
                    b[i[j]] = max(b[i[j]],i.count(i[j]))
                else:
                    b[i[j]]=1
        res = []
        for i in A:
            c = copy.deepcopy(b)
            for j in range(len(i)):
                if i[j] in c:
                    c[i[j]]-=1
            res.append(i)
            for key in c:
                if c[key] >0:
                    res.pop()
                    break
        return res
		