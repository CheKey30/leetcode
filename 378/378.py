```
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```
### soution 1: heap
class Solution:
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        m,n = len(matrix), len(matrix[0])
        p = [(matrix[0][0], 0, 0)]
        res = 0
        for _ in range(k):
            res, i, j = heapq.heappop(p)
            if j==0 and i+1<m:
                heapq.heappush(p,(matrix[i+1][j],i+1,j))
            if j+1<n:
                heapq.heappush(p,(matrix[i][j+1],i,j+1))
        return res


### solution 2: binary search
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        l = matrix[0][0]
        m = len(matrix)
        n = len(matrix[0])
        h = matrix[m-1][n-1]
        while l<h:
            mid = (l+h)//2
            count = 0
            j = n-1
            i = 0
            while j>=0 and i<m:
                if matrix[i][j]<=mid:
                    count+=(j+1)
                    i+=1
                else:
                    j-=1
            if count<k:
                l = mid+1
            else:
                h = mid
        return l