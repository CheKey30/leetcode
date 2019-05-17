```
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        matrix = [[0 for _ in range(n)] for _ in range(n)]
        left = top = 0
        right = bottom = n-1
        count =1
        while count<=n*n:
            for j in range(left,right+1):
                matrix[top][j] = count
                count+=1
            top+=1
            for j in range(top,bottom+1):
                matrix[j][right]=count
                count+=1
            right-=1
            for j in range(right,left-1,-1):
                matrix[bottom][j]=count
                count+=1
            bottom-=1
            for j in range(bottom,top-1,-1):
                matrix[j][left]=count
                count+=1
            left+=1
        return matrix