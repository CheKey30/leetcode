```
Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:

0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 

Example 1:

Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
```
class Solution:
    def maxSumTwoNoOverlap(self, A: List[int], L: int, M: int) -> int:
        if not A:
            return 0
        sum_A = [0]*len(A)
        for i in range(len(A)):
            sum_A[i] = sum(A[:i+1])
        max_L= sum_A[L-1]
        max_M = sum_A[M-1]
        res = sum_A[L+M-1]
        for i in range(L+M,len(A)):
            max_L = max(max_L,sum_A[i-M]-sum_A[i-L-M])
            max_M = max(max_M,sum_A[i-L]-sum_A[i-M-L])
            res = max(res, max(max_M+sum_A[i]-sum_A[i-L], max_L+sum_A[i]-sum_A[i-M]))
        return res
                