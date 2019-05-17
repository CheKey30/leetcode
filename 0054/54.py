```
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        m = len(matrix)
        n = len(matrix[0])
        res = []
        top = left = 0
        right = n-1
        bottom = m-1
        count =0
        while count<n*m:
            for i in range(left, right+1):
                res.append(matrix[top][i])
                count+=1
            top+=1
            if top>bottom:
                break
            for i in range(top,bottom+1):
                res.append(matrix[i][right])
                count+=1
            right-=1
            if right<left:
                break
            for i in range(right,left-1,-1):
                res.append(matrix[bottom][i])
                count+=1
            bottom-=1
            if top>bottom:
                break
            for i in range(bottom,top-1,-1):
                res.append(matrix[i][left])
                count+=1
            left+=1
            if left>right:
                break
        return res
        