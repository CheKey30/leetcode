```
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        def backtrack(n,k,index,cur,res):
            if len(cur)==k:
                res.append(cur[:])
                return
            for i in range(index,n):
                cur.append(i)
                backtrack(n,k,i+1,cur,res)
                cur.pop()
        res = []
        backtrack(n+1,k,1,[],res)
        return res