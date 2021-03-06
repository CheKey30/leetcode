```
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
```
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m = len(matrix)
        n = len(matrix[0])
        l,r = 0, m*n-1
        while l<=r:
            mid = (l+r)//2
            i = mid//n
            j = mid%n
            if matrix[i][j]==target:
                return True
            elif matrix[i][j]<target:
                l = mid+1
            else:
                r = mid-1
        return False