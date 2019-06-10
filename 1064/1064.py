```
Given an array A of distinct integers sorted in ascending order, return the smallest index i that satisfies A[i] == i.  Return -1 if no such i exists.

 

Example 1:

Input: [-10,-5,0,3,7]
Output: 3
Explanation: 
For the given array, A[0] = -10, A[1] = -5, A[2] = 0, A[3] = 3, thus the output is 3.
```
class Solution:
    def fixedPoint(self, A: List[int]) -> int:
        if not A:
            return -1
        l,r = 0,len(A)-1
        while l<r:
            mid = (l+r)//2
            if A[mid]<mid:
                l = mid+1
            else:
                r = mid
        if A[r] != r:
            return -1
        else:
            return r
                